package problems.p657;

class Solution2 {

    // switch is slower
    public boolean judgeCircle(String moves) {
        int[] steps = new int[127];
        for (int i = 0; i < moves.length(); i++) {
            steps[moves.charAt(i)]++;
        }
        return steps['R'] == steps['L'] && steps['U'] == steps['D'];
    }
}