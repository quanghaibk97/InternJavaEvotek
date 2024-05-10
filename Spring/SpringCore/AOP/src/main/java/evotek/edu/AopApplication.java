package evotek.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AopApplication {

  public static void main(String[] args) throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Hello hello = (Hello) context.getBean("helloProxy");
    hello.method1();
    System.out.println("\n");
    hello.method2();
    System.out.println("\n");
    hello.method3();
  }

}
