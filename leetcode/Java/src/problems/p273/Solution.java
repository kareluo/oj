package problems.p273;

class Solution {

    private static class NumberWord {

        int number;

        String word;

        boolean unit = false;

        NumberWord(int number, String word) {
            this(number, word, false);
        }

        NumberWord(int number, String word, boolean unit) {
            this.number = number;
            this.word = word;
            this.unit = unit;
        }
    }

    private static final NumberWord[] sNumberWords = {
            new NumberWord(1000000000, "Billion", true),
            new NumberWord(1000000, "Million", true),
            new NumberWord(1000, "Thousand", true),
            new NumberWord(100, "Hundred", true),
            new NumberWord(90, "Ninety"),
            new NumberWord(80, "Eighty"),
            new NumberWord(70, "Seventy"),
            new NumberWord(60, "Sixty"),
            new NumberWord(50, "Fifty"),
            new NumberWord(40, "Forty"),
            new NumberWord(30, "Thirty"),
            new NumberWord(20, "Twenty"),
            new NumberWord(19, "Nineteen"),
            new NumberWord(18, "Eighteen"),
            new NumberWord(17, "Seventeen"),
            new NumberWord(16, "Sixteen"),
            new NumberWord(15, "Fifteen"),
            new NumberWord(14, "Fourteen"),
            new NumberWord(13, "Thirteen"),
            new NumberWord(12, "Twelve"),
            new NumberWord(11, "Eleven"),
            new NumberWord(10, "Ten"),
            new NumberWord(9, "Nine"),
            new NumberWord(8, "Eight"),
            new NumberWord(7, "Seven"),
            new NumberWord(6, "Six"),
            new NumberWord(5, "Five"),
            new NumberWord(4, "Four"),
            new NumberWord(3, "Three"),
            new NumberWord(2, "Two"),
            new NumberWord(1, "One")
    };

    private static final int sZeroIndex = sNumberWords.length - 1;

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        } else {
            StringBuilder sb = new StringBuilder();
            number(sb, num, 0);
            return sb.toString();
        }
    }

    private void number(StringBuilder sb, int num, int index) {
        for (int i = index; i < sNumberWords.length; i++) {
            if (num >= sNumberWords[i].number) {
                NumberWord nw = sNumberWords[i];
                int eNum = num % nw.number;
                if (nw.unit) {
                    number(sb, num / nw.number, i + 1);
                }

                if (sb.length() > 0) sb.append(" ");
                sb.append(nw.word);

                if (eNum > 0) {
                    number(sb, eNum, i + 1);
                }
                return;
            }
        }
    }
}