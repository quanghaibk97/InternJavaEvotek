package evotek.edu.service;

import evotek.edu.model.Student;
import evotek.edu.repository.StudentRepository;
import evotek.edu.repository.StudentRepositoryImpl;
import java.util.List;

public interface StudentService {
  public List<Student> getAllStudent();
}
