package evotek.edu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SocketHandler;

public class ListSample {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(2023);
        list.add("Fresher Academy");
        list.add(new Date());

        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(2));

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        Object object = list.get(0);
        int number = (Integer)object;
        System.out.println(number);


    }
}
