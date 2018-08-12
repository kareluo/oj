package problems.p599;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            return findRestaurant(list2, list1);
        }

        List<String> favorites = new ArrayList<>();
        int length = list1.length + list2.length - 1;
        for (int i = 0; i < length; i++) {
            int max = Math.min(i, list2.length - 1);
            int min = i - max;
            for (int j = min, k = max; j < list1.length && k >= 0; j++, k--) {
                if (list1[j].equals(list2[k])) {
                    favorites.add(list1[j]);
                }
            }
            if (!favorites.isEmpty()) break;
        }

        return favorites.toArray(new String[favorites.size()]);
    }
}