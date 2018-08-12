package problems.p347;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequents = new HashMap<>();
        for (int num : nums) {
            frequents.put(num, frequents.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> tops = new PriorityQueue<>((o1, o2) -> {
            if (o2.getValue().equals(o1.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        tops.addAll(frequents.entrySet());

        List<Integer> values = new ArrayList<>(k);
        while (k-- > 0) {
            values.add(tops.poll().getKey());
        }

        return values;
    }
}