package evotek.edu;




import evotek.edu.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionShorting {
    public static void main(String[] args) {
        List<Integer> yearList = new ArrayList<>();
        yearList.add(2024);
        yearList.add(2023);
        yearList.add(2025);

        for (Integer i : yearList){
            System.out.println(i);
        }

        Collections.sort(yearList);
        System.out.println("==========");
        for (Integer i : yearList){
            System.out.println(i);
        }

        List<String> nameList = new ArrayList<>();
        nameList.add("Fresher");
        nameList.add("Academy");
        nameList.add("Ducky");
        System.out.println("==========");
        Collections.sort(nameList);
        for (String name : nameList){
            System.out.println(name);
        }

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Ducky", 6));
        studentList.add(new Student("Clover", 8));
        studentList.add(new Student("Hugo", 7));
//        Collections.sort(studentList);
        Collections.sort(studentList, new StudentComparator());
        System.out.println(studentList);

    }
}
