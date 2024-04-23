package evotek.edu;

import evotek.edu.model.Student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    public static void main(String[] args) {

    }

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
