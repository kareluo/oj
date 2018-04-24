package problems.p717;

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int one = 0;
        for (int i = bits.length - 2; i >= 0; i--) {
            if (bits[i] == 1) {
                one++;
            } else break;
        }

        return bits[bits.length - 1] == 0 && (one & 1) == 0;
    }
}