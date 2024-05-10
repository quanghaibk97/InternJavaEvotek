package evotek.edu.demospringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoSpringController {
  @GetMapping("/hello")
  String sayHello(){
    return "Hello Spring Boot";
  }

}
