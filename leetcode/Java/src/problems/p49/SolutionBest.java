package problems.p49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionBest {

    private static final int[] primes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101
    };

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> exits = new HashMap<>();

        for (String str : strs) {
            int key = 1;
            for (char ch : str.toCharArray()) {
                key *= primes[ch - 97];
            }
            List<String> values = exits.get(key);
            if (values == null) {
                values = new ArrayList<>();
                exits.put(key, values);
            }
            values.add(str);
        }
        return new ArrayList<>(exits.values());
    }
}
