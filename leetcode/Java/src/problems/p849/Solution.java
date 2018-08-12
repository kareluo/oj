package problems.p849;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int longest = 0, zero = 0;
        int i = 0;
        while (i < seats.length && seats[i++] == 0) longest += 2;
        while (i < seats.length) {
            if (seats[i] == 1) {
                if (zero > longest) {
                    longest = zero;
                }
                zero = 0;
            } else zero++;
            i++;
        }
        longest = (longest + 1) >> 1;
        if (zero > longest) {
            longest = zero;
        }
        return longest;
    }
}