package config;

import evotek.edu.repository.StudentRepository;
import evotek.edu.repository.StudentRepositoryImpl;
import evotek.edu.service.StudentService;
import evotek.edu.service.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
  @Bean(name = "studentService")
  public StudentService getStudentService(){
//    StudentServiceImpl studentService = new StudentServiceImpl();
//    studentService.setStudentRepository2(getStudentRepository());
//    return studentService;
    return new StudentServiceImpl();
  }

  @Bean(name = "studentRepository")
  public StudentRepository getStudentRepository(){
    return new StudentRepositoryImpl();
  }
}
