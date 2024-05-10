package evotek.edu.controller;

import evotek.edu.dto.response.EmployeeDepartmentResponse;
import evotek.edu.service.EmployeeService;
import evotek.edu.vo.EmployeeRequest;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @PostMapping("/addEmployee")
  public String saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
    return employeeService.saveEmployee(employeeRequest);
  }

  @PostMapping("/updateEmployee/{employeeId}")
  public void updateEmployee(@PathVariable long employeeId,
      @RequestBody EmployeeRequest employeeRequest) throws Exception {
    employeeService.updateEmployeeId(employeeId, employeeRequest);
  }

  @GetMapping("/getInfoEmployee")
  public List<EmployeeDepartmentResponse> getInfoEmployee() {
    return employeeService.getEmployee();
  }

}
