package problems.P204;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionBest solutionBest = new SolutionBest();
        for (int i = 0; i <= 1500; i++) {
            if (solution.countPrimes(i) != solutionBest.countPrimes(i)) {
                System.out.println(i);
            }
        }
    }
}
