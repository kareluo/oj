package problems.p412;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> nums = new ArrayList<>(n);
        String fizz = "Fizz", buzz = "Buzz", fizzBuzz = "FizzBuzz";
        for (int i = 1, j = i % 3, k = i % 5; i <= n; ) {
            if (j == 0 && k == 0) nums.add(fizzBuzz);
            else if (j == 0) nums.add(fizz);
            else if (k == 0) nums.add(buzz);
            else nums.add(String.valueOf(i));
            i++;
            j = i % 3;
            k = i % 5;
        }
        return nums;
    }
}