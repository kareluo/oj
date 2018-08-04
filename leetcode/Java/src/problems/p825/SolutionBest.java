package problems.p825;

public class SolutionBest {

    public int numFriendRequests(int[] nums) {
        if (nums.length < 2) return 0;
        int[] ages = new int[121];
        for (int num : nums) {
            ages[num]++;
        }

        int requests = 0;
        int[] persons = new int[121];
        for (int i = 1; i <= 120; i++) {
            persons[i] = persons[i - 1] + ages[i];
            if (ages[i] > 0 && (i >> 1) + 7 < i) {
                requests += (persons[i] - persons[(i >> 1) + 7] - 1) * ages[i];
            }
        }

        return requests;
    }
}
