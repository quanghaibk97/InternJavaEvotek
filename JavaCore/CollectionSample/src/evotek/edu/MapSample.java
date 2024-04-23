package evotek.edu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapSample {
    public static void main(String[] args) {
        Map<Integer, String> resultMap = new HashMap<>();
        resultMap.put(2023, "Good");
        resultMap.put(2024, "Excellent");
        resultMap.put(2025, "Good1");
        resultMap.put(2025, "Good2");

        System.out.println(resultMap.size());
        String result = resultMap.get(2023);
        System.out.println(result);

        Set<Integer> keySet = resultMap.keySet();
        Iterator<Integer> iterator = keySet.iterator();

        Integer key = 0;
        while (iterator.hasNext()){
            key = iterator.next();
            System.out.println(key + ":" + resultMap.get(key));
        }
    }
}
