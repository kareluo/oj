package problems.p420;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public int strongPasswordChecker(String s) {
        int count = 0, answer = 0;
        if (s.length() < 6) {
            count = 6 - s.length();
        }

        if (s.length() > 20) {
            count = 20 - s.length();
        }

        int change = 0;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasNumber = false;

        char preChar = 0;
        int preCharCount = 1;
        List<Integer> repeats = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                hasLowerCase = true;
            }

            if (ch >= 'A' && ch <= 'Z') {
                hasUpperCase = true;
            }

            if (ch >= '0' && ch <= '9') {
                hasNumber = true;
            }

            if (preChar == ch) {
                preCharCount++;
            } else if (preCharCount > 2) {
                repeats.add(preCharCount);
                preCharCount = 1;
            } else {
                preCharCount = 1;
            }

            preChar = ch;
        }

        if (preCharCount > 2) {
            repeats.add(preCharCount);
            preCharCount = 1;
        }

        if (!hasLowerCase) change++;
        if (!hasUpperCase) change++;
        if (!hasNumber) change++;

        if (count > 0 && change > 0) {
            if (change > count) {
                change -= count;
            } else {
                change = 0;
            }
        }

        if (!repeats.isEmpty()) {
            for (int repeat : repeats) {
                if (count < 0) {
                    if (-count >= repeat - 2) {
                        count += repeat - 2;
                        answer += repeat - 2;
                        repeat = 0;
                    } else {
                        repeat += count;
                        answer -= count;
                        count = 0;
                    }
                } else if (count > 0) {
                    if (count >= (repeat - 1) >> 1) {
                        count -= (repeat - 1) >> 1;
                        answer += (repeat - 1) >> 1;
                        repeat = 0;
                    } else {
                        repeat -= count << 1;
                        answer += count;
                        count = 0;
                    }
                }

                if (repeat > 0 && change > 0) {
                    if (change >= repeat / 3) {
                        change -= repeat / 3;
                        answer += repeat / 3;
                        repeat = 0;
                    } else {
                        repeat -= change * 3;
                        answer += change;
                        change = 0;
                    }
                }

                if (repeat > 0) {
                    answer += repeat / 3;
                    repeat = 0;
                }
            }
        }

        if (Math.abs(count) > 0) {
            answer += Math.abs(count);
        }

        if (change > 0) {
            answer += change;
        }

        return answer;
    }
}