package evotek.edu;

import evotek.edu.model.Student;
import evotek.edu.model.Teacher;

public class GenericClass {
    public static void main(String[] args) {
        DataAccess<Student> studentDataAccess = new DataAccess<>();
        studentDataAccess.save(new Student("Peter", 5));

        DataAccess<Teacher> teacherDataAccess = new DataAccess<>();
        teacherDataAccess.update(new Teacher("Peter"));
    }
}
