package evotek.edu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericCollection {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2023);
        list.add(2024);
        list.add(2025);

        Integer number = list.get(0);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        for (Integer i : list){
            System.out.println(i);
        }

    }
}
