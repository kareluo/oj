package problems.p398;

import java.util.Arrays;
import java.util.Random;

class Solution {

    private Two[] values;

    private Random random;

    public Solution(int[] nums) {
        random = new Random();
        values = new Two[nums.length];
        for (int i = 0; i < nums.length; i++) {
            values[i] = new Two(nums[i], i);
        }
        Arrays.sort(values);
    }

    public int pick(int target) {
        int index = search(target);
        if (index < 0) {
            return -1;
        }

        int start = index - 1, end = index + 1;
        while (start >= 0 && values[start].value == target) start--;
        while (end < values.length && values[end].value == target) end++;
        start++;
        return values[random.nextInt(end - start) + start].index;
    }

    private int search(int target) {
        int low = 0, high = values.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = values[mid].value - target;

            if (cmp < 0) low = mid + 1;
            else if (cmp > 0) high = mid - 1;
            else return mid;
        }
        return -(low + 1);
    }

    public static class Two implements Comparable<Two> {

        private int value;

        private int index;

        public Two(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Two o) {
            if (this.value > o.value) {
                return 1;
            } else if (this.value < o.value) {
                return -1;
            }
            return 0;
        }
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */