package problems.p794;

class Solution {
    public boolean validTicTacToe(String[] board) {
        if (board.length < 3) return false;
        int x = 0, o = 0;
        char[][] bd = new char[3][3];
        for (int i = 0; i < 3; i++) {
            if (board[i].length() < 3) return false;
            for (int j = 0; j < 3; j++) {
                bd[i][j] = board[i].charAt(j);
                if (bd[i][j] == 'X') {
                    x++;
                } else if (bd[i][j] == 'O') {
                    o++;
                }
            }
        }
        if (o > x || x - o > 1) {
            return false;
        }

        int value;
        int xxx = 0, ooo = 0;
        for (int i = 0; i < 3; i++) {
            value = line(bd[i]);
            xxx += value;
            ooo += value;

            value = line(bd[0][i], bd[1][i], bd[2][i]);
            xxx += value;
            ooo += value;
        }

        value = line(bd[0][0], bd[1][1], bd[2][2]);
        xxx += value;
        ooo += value;

        value = line(bd[0][2], bd[1][1], bd[2][0]);
        xxx += value;
        ooo += value;

        xxx &= 15;
        ooo >>= 4;

        if (xxx > 0 && ooo > 0) return false;
        if (xxx > 0 && x <= o) return false;
        if (ooo > 1 || ooo == 1 && x > o) {
            return false;
        }

        return true;
    }

    private int line(char... line) {
        if (line[0] == line[1] && line[1] == line[2]) {
            if (line[1] == 'X') {
                return 1;
            } else if (line[1] == 'O') {
                return 16;
            }
        }
        return 0;
    }
}