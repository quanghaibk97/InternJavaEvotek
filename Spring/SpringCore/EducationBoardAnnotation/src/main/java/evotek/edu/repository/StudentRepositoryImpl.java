package evotek.edu.repository;

import evotek.edu.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {
  public List<Student> getAllStudent(){
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("Quang Hai", "Ha Noi"));
    return studentList;
  }
}
