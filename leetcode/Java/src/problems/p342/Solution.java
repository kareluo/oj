package problems.p342;

class Solution {
    public boolean isPowerOfFour(int num) {
        if (num < 1 || (num & 0x55555554) != num) return false;
        if ((num & 0x5554) != num) {
            if ((num & 0x5554) != 0) {
                return false;
            }

            num >>= 16;
            if ((num & 1) == 1) {
                return num == 1;
            }
        }

        if ((num & 0x54) != num) {
            if ((num & 0x54) != 0) {
                return false;
            }
            num >>= 8;

            if ((num & 1) == 1) {
                return num == 1;
            }
        }

        if ((num & 0x4) != num) {
            if ((num & 0x4) != 0) {
                return false;
            }

            num >>= 4;
        }
        return num == 1 || num == 4;
    }
}

class Solution2 {
    public boolean isPowerOfFour(int num) {
        if (num < 1 || (num & 0x55555555) != num) return false;
        if ((num & 0x5555) != num) {
            if ((num & 0x5555) != 0) {
                return false;
            }
            num >>= 16;
        }

        if ((num & 0x55) != num) {
            if ((num & 0x55) != 0) {
                return false;
            }
            num >>= 8;
        }

        if ((num & 0x5) != num) {
            if ((num & 0x5) != 0) {
                return false;
            }
            num >>= 4;
        }

        return num == 1 || num == 4;
    }
}