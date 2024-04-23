package evotek.edu;

import java.util.ArrayList;

public class Management {

  public static void main(String[] args) {
    Enrollment enrollment = new Enrollment(new ArrayList<Student>());
    Thread thread = new Thread(enrollment, "Student Enrollment");
    thread.start();
  }

}
