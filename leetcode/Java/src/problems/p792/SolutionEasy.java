package problems.p792;

import java.util.HashSet;
import java.util.Set;

public class SolutionEasy {

    public int numMatchingSubseq(String S, String[] words) {
        int num = 0;
        Set<String> subs = new HashSet<>();
        Set<String> unsubs = new HashSet<>();
        for (String word : words) {
            if (subs.contains(word)) {
                num++;
            } else if (!unsubs.contains(word)) {
                int pos = 0;
                boolean next = false;
                for (int i = 0; i < word.length(); i++) {
                    int index = S.indexOf(word.charAt(i), pos);
                    if (index < 0) {
                        next = true;
                        break;
                    }
                    pos = index + 1;
                }
                if (next) {
                    unsubs.add(word);
                    continue;
                }
                num++;
                subs.add(word);
            }
        }
        return num;
    }
}
