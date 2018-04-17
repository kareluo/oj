package problems.p818;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int racecar(int target) {
        int[] v = new int[target << 2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1, 0, 0, target << 1});
        while (!queue.isEmpty()) {
            int[] car = queue.poll();
            int[] accelerate = new int[]{car[0] + car[1], car[1] << 1, car[2] + 1, 0, 0};
            

            if (accelerate[0] == target) {
                return accelerate[2];
            }
            if (accelerate[0] < (target << 1) && accelerate[0] >= 0) {
                v[accelerate[0]]++;
                queue.offer(accelerate);
            }
            int[] reverse = {car[0], 0, car[2] + 1, -car[3]};
            if (v[reverse[0]] <= 4) {
                queue.offer(reverse);
            }
        }
        return 0;
    }
}