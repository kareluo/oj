package problems.p705;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        MyHashSet myMap = new MyHashSet();
        Set<Integer> map = new HashSet<>();

        int k = 0;
        int[] keys = new int[10000];
        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt(1000001);
            keys[k++] = key;
            myMap.add(key);
            map.add(key);
        }

        for (int i = 0; i < 100; i++) {
            int key = random.nextInt(1000001);
            myMap.remove(key);
            map.remove(key);
        }

        for (int i = 0; i < k; i++) {
            if (map.contains(keys[i]) != myMap.contains(keys[i])) {
                System.out.println(i);
                System.out.println(keys[i]);
                break;
            }
        }
    }
}
