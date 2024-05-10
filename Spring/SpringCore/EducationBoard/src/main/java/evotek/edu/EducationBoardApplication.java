package evotek.edu;

import config.ApplicationConfiguration;
import evotek.edu.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class EducationBoardApplication {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
        ApplicationConfiguration.class);
    StudentService studentService = context.getBean("studentService", StudentService.class);
    System.out.println(studentService.getAllStudent().size());
  }
}
