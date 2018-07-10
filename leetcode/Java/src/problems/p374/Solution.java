package problems.p374;/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int number;

    public int guessNumber(int n) {
        int begin = 1, end = n, mid;
        do {
            mid = begin + ((end - begin) >> 1);
            int guess = guess(mid);
            if (guess == 0) return mid;
            if (guess > 0) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        } while (begin <= end);
        return 0;
    }

    public int guess(int num) {
        if (num == number) return 0;
        if (num > number) return -1;
        return 1;
    }
}

class GuessGame {

}