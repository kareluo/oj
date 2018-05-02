package problems.p599;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length < list2.length) {
            return findRestaurant(list2, list1);
        }

        boolean interest = false;
        int length = list1.length + list2.length - 1;
        List<String> restaurants = new ArrayList<>();
        for (int k = 0; k < length; k++) {
            interest = false;
            for (int i = 0, j = k; j >= 0; i++, j--) {
                if (list1[i].equals(list2[j])) {
                    interest = true;
                    restaurants.add(list1[i]);
                }
            }
            if (interest) break;
        }

        String[] res = new String[restaurants.size()];
        restaurants.toArray(res);
        return res;
    }
}