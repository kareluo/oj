package problems.p11;

class Solution {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        Heap heap = new Heap(height.length);
        for (int i = 0; i < height.length; i++) {
            heap.insert(height[i], i);
        }

        int[] v = heap.poll();
        int begin = v[1], end = v[1], h = v[0], capacity = 0, cap;

        while (!heap.isEmpty()) {
            v = heap.poll();
            if (v[1] < begin) {
                cap = (end - v[1]) * v[0];
                if (cap > capacity) {
                    capacity = cap;
                }
                begin = v[1];
            } else if (v[1] > end) {
                cap = (v[1] - begin) * v[0];
                if (cap > capacity) {
                    capacity = cap;
                }
                end = v[1];
            }
        }

        return capacity;
    }

    static class Heap {

        private int size;

        private int capacity;

        private int[][] values;

        public Heap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.values = new int[capacity][3];
        }

        public void insert(int val, int index) {
            values[size][0] = val;
            values[size][1] = index;
            int i = size++;
            while (values[i >> 1][0] < values[i][0]) {
                swap(i >> 1, i);
                i >>= 1;
            }
        }

        public int[] poll() {
            int[] v = new int[]{values[0][0], values[0][1]};
            swap(0, --size);
            int i = 0;

            while (true) {
                int k = i, j = i << 1;
                if (j < size && values[k][0] < values[j][0]) {
                    k = j;
                }

                j++;
                if (j < size && values[k][0] < values[j][0]) {
                    k = j;
                }

                if (i != k) {
                    swap(i, k);
                    i = k;
                } else break;
            }

            return v;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void swap(int i, int j) {
            if (i == j) return;

            values[i][0] ^= values[j][0];
            values[j][0] ^= values[i][0];
            values[i][0] ^= values[j][0];

            values[i][1] ^= values[j][1];
            values[j][1] ^= values[i][1];
            values[i][1] ^= values[j][1];
        }
    }
}