package evotek.edu.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDepartmentResponse {
  long employeeId;
  String empName;
  String email;
  long departmentId;
  String departmentName;
  String departmentCode;

}
