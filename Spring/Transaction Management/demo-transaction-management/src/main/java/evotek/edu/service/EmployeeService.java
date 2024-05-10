package evotek.edu.service;

import evotek.edu.dto.response.EmployeeDepartmentResponse;
import evotek.edu.entity.Department;
import evotek.edu.entity.Employee;
import evotek.edu.repository.DepartmentRepository;
import evotek.edu.repository.EmployeeRepository;
import evotek.edu.vo.EmployeeRequest;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Transactional
@Service
public class EmployeeService {

  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private EmployeeRepository employeeRepository;

  private List<Department> departments;


  @PostConstruct
  public void initialize() {
    departments = departmentRepository.findAll();

    // Kiểm tra nếu không có phòng ban nào tồn tại, ta tạo ra một phòng ban mặc định
    if (departments.isEmpty()) {
      Department defaultDepartment = new Department();
      defaultDepartment.setDepartmentName("Default Department");
      defaultDepartment.setDepartmentCode("Department 1");
      departmentRepository.save(defaultDepartment);
      departments.add(defaultDepartment);
    }
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public String saveEmployee(EmployeeRequest employeeRequest) {

    Department department = new Department();
    department.setDepartmentName(employeeRequest.getDepartmentName());
    Long departmentID = departmentRepository.save(department).getDepartmentId();

//    Employee employee = new Employee();
    Employee employee = null;
    employee.setEmployeeName(employeeRequest.getEmployeeName());
    employee.setEmail(employeeRequest.getEmail());
    employee.setDepartmentId(departmentID);
    employeeRepository.save(employee);

    return "Employee is saved with EmployeeID = " + employee.getEmployeeId();
  }

  @Transactional(rollbackFor =Exception.class)
  public void updateEmployeeId(long employeeId, EmployeeRequest request) throws Exception {
    Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new RuntimeException());
    employee.setEmployeeName(request.getEmployeeName());
    employee.setEmail(request.getEmail());
    employeeRepository.save(employee);
    throw new Exception("checked exception");
  }

  public List<EmployeeDepartmentResponse> getEmployee() {
    List<Employee> employeeList = employeeRepository.findAll();
    List<EmployeeDepartmentResponse> employeeDepartmentResponseList = employeeList.stream()
        .map(employee -> {
          EmployeeDepartmentResponse response = new EmployeeDepartmentResponse();
          response.setEmployeeId(employee.getEmployeeId());
          response.setEmpName(employee.getEmployeeName());
          response.setEmail(employee.getEmail());
          response.setDepartmentId(employee.getDepartmentId());

          Department department = departmentRepository.findById(employee.getDepartmentId())
              .orElseThrow(() -> new RuntimeException());

          response.setDepartmentName(department.getDepartmentName());
          response.setDepartmentCode(department.getDepartmentCode());
          return response;
        })
        .toList();
    return employeeDepartmentResponseList;

  }

}
