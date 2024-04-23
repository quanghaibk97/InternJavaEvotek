package evotek.edu;

import evotek.edu.model.Student;
import evotek.edu.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Management {

    public <T> void manage(List<T> list, T t){
        if (list == null){
            return;
        }
        list.add(t);
        System.out.println(list);
    }

    public static void main(String[] args) {
        Management management = new Management();
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Ducky", 6));
        studentList.add(new Student("Clover", 8));
        studentList.add(new Student("Hugo", 7));
        management.manage(studentList, new Student("Victor", 9));

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher("Ducky"));
        teacherList.add(new Teacher("Clover"));
        management.manage(teacherList, new Teacher(" Victor"));
    }
}
