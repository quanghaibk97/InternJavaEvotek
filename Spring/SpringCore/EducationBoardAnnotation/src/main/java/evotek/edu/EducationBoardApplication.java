package evotek.edu;

import evotek.edu.model.Student;
import evotek.edu.service.StudentService;
import evotek.edu.service.StudentServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class EducationBoardApplication {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    StudentService service = context.getBean("studentService", StudentService.class);
    System.out.println(service.getAllStudent().size());
  }

}
