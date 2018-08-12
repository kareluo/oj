package problems.p705;

class MyHashSet {

    int head;

    private int[] keys = new int[LENGTH];

    private int[][] values = new int[10001][2];

    private static final int LENGTH = 199999;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        head = 1;
    }

    public void add(int key) {
        int i = key % LENGTH;
        if (keys[i] == 0) {
            values[head][0] = key;
            values[head][1] = 0;
            keys[i] = head++;
        } else {
            int j = keys[i];
            while (j != 0 && values[j][0] != key) {
                j = values[j][1];
            }
            if (j == 0) {
                values[head][0] = key;
                values[head][1] = keys[i];
                keys[i] = head++;
            }
        }
    }

    public void remove(int key) {
        int i = key % LENGTH;
        if (keys[i] != 0) {
            int j = keys[i], k = 0;
            while (j != 0 && values[j][0] != key) {
                k = j;
                j = values[j][1];
            }
            if (j != 0) {
                if (k == 0) {
                    keys[i] = values[j][1];
                } else {
                    values[k][1] = values[j][1];
                }
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int i = key % LENGTH;
        if (keys[i] != 0) {
            int j = keys[i];
            while (j != 0 && values[j][0] != key) {
                j = values[j][1];
            }
            return j != 0;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */