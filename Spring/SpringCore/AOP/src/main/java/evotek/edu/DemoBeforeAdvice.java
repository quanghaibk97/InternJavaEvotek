package evotek.edu;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class DemoBeforeAdvice implements MethodBeforeAdvice {
  public void before(Method method, Object[] args, Object target) throws Throwable {
    System.out.println("before method: " + method.getName());
  }
}