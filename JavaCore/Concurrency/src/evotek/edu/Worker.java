package evotek.edu;

import java.util.concurrent.TimeUnit;

public class Worker implements Runnable{

  private String name;

  public Worker() {
  }

  public Worker(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    int count = 0;
    int a = 1;
    while (count++ < 5){
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(this.getName());
    }

  }
}
