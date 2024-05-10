package evotek.edu.service;

import evotek.edu.model.Student;
import evotek.edu.repository.StudentRepository;
import evotek.edu.repository.StudentRepositoryImpl;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService{
  private StudentRepository studentRepository = new StudentRepositoryImpl();

  public StudentServiceImpl() {
    super();
    System.out.println("Default Constructor Injected");
  }

  public StudentServiceImpl(StudentRepository studentRepository3) {
    super();
    this.studentRepository = studentRepository3;
    System.out.println("Constructor Injection");
  }

  public StudentRepository getStudentRepository() {
    return studentRepository;
  }

  public void setStudentRepository2(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
    System.out.println("Setter injection");
  }

  public List<Student> getAllStudent(){
    return studentRepository.getAllStudent();
  }
}
