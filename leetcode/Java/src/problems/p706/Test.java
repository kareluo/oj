package problems.p706;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        MyHashMap myMap = new MyHashMap();
        Map<Integer, Integer> map = new HashMap<>();

        int k = 0;
        int[] keys = new int[10000];
        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt(1000001);
            int value = random.nextInt();
            keys[k++] = key;
            myMap.put(key, value);
            map.put(key, value);
        }
        for (int i = 0; i < 100; i++) {
            int key = random.nextInt(1000001);
            myMap.remove(key);
            map.remove(key);
        }

        for (int i = 0; i < k; i++) {
//            System.out.println(map.get(keys[i]));
//            System.out.println(myMap.get(keys[i]));
            if (map.getOrDefault(keys[i], -1) != myMap.get(keys[i])) {
                System.out.println(i);
                System.out.println(keys[i]);
                break;
            }
        }
    }
}
