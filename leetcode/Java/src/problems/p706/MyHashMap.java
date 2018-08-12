package problems.p706;

class MyHashMap {

    private int[] keys = new int[LENGTH];

    private int[][] values = new int[10001][3];

    private int head;

    private static final int LENGTH = 100000;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        head = 1;
        for (int i = 1; i < values.length; i++) {
            values[i][0] = i + 1;
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int i = key % LENGTH;
        int j = keys[i];
        if (j == 0) {
            j = head;
            head = values[head][0];

            values[j][0] = 0;
            values[j][1] = key;
            values[j][2] = value;

            keys[i] = j;
        } else {
            while (values[j][0] != 0 && values[j][1] != key) {
                j = values[j][0];
            }
            if (values[j][1] == key) {
                values[j][2] = value;
            } else {
                int k = head;
                head = values[head][0];

                values[k][0] = values[j][0];
                values[k][1] = key;
                values[k][2] = value;

                values[j][0] = k;
            }
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int i = key % LENGTH;
        if (keys[i] != 0) {
            int j = keys[i];
            while (j != 0 && values[j][1] != key) {
                j = values[j][0];
            }
            if (j != 0) {
                return values[j][2];
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int i = key % LENGTH;
        if (keys[i] != 0) {
            int j = keys[i], k = 0;
            while (j != 0 && values[j][1] != key) {
                k = j;
                j = values[j][0];
            }
            if (j != 0) {
                if (k == 0) {
                    keys[i] = values[j][0];
                } else {
                    values[k][0] = values[j][0];
                }
                values[j][0] = head;
                head = j;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */