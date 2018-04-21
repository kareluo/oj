package problems.p476;

class Solution {

    public int findComplement(int num) {
        int i = 1, complement = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                complement |= i;
            }
            i <<= 1;
            num >>= 1;
        }
        return complement;
    }
}