package problems.p703;

class KthLargest {

    private int size = 0;

    private int[] numbers;

    public KthLargest(int k, int[] nums) {
        this.numbers = new int[k];
        int i = 0;
        while (i < k && i < nums.length) {
            push(nums[i++]);
        }
        while (i < nums.length) {
            add(nums[i++]);
        }
        while (size < k) {
            push(Integer.MIN_VALUE);
        }
    }

    public int add(int val) {
        if (val > numbers[0]) {
            numbers[0] = val;
            int i = 0, j;
            while (i < size) {
                j = i;
                if ((i << 1) < size && numbers[j] > numbers[i << 1]) {
                    j = i << 1;
                }
                if (((i << 1) | 1) < size && numbers[j] > numbers[(i << 1) | 1]) j = (i << 1) | 1;
                if (j != i) {
                    swap(i, j);
                    i = j;
                } else break;
            }
        }
        return numbers[0];
    }

    private void push(int num) {
        numbers[size] = num;
        int i = size++;
        while (i > 0) {
            if (numbers[i] < numbers[i >> 1]) {
                swap(i, i >> 1);
            } else break;
            i >>= 1;
        }
    }

    private void swap(int i, int j) {
        numbers[i] ^= numbers[j];
        numbers[j] ^= numbers[i];
        numbers[i] ^= numbers[j];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */