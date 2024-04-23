package evotek.edu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetSample {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(2023);
        set.add(2024);
        set.add(2025);

        System.out.println(set.size());

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
