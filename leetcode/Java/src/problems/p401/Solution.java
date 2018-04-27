package problems.p401;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> tiems = new ArrayList<>();
        watch(tiems, 0, num, 10);
        return tiems;
    }

    private void watch(List<String> times, int num, int one, int bits) {
        if (bits < 0) return;
        if (one == 0) {
            num <<= bits;
            int hour = num >> 6;
            int minute = num & 63;
            if (hour < 12 && minute < 60) {
                times.add(String.format("%d:%02d", hour, minute));
            }
            return;
        }
        watch(times, num << 1, one, bits - 1);
        watch(times, (num << 1) | 1, one - 1, bits - 1);
    }
}