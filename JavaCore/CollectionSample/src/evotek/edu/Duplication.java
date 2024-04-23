package evotek.edu;

import evotek.edu.model.Student;

import java.util.HashSet;
import java.util.Set;

public class Duplication {
    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student("Ducky", 6));
        studentSet.add(new Student("Clover", 8));
        studentSet.add(new Student("Hugo", 7));
        System.out.println(studentSet);
        studentSet.add(new Student("Clover", 9));
        System.out.println(studentSet);
    }
}
