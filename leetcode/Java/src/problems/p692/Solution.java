package problems.p692;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0) {
            return new LinkedList<>();
        }
        Arrays.sort(words);
        String previous = words[0];
        List<String> kStrings = new LinkedList<>();
        List<Integer> kCounts = new LinkedList<>();

        int count = 1;
        for (int i = 1; i < words.length; i++) {
            if (words[i].equals(previous)) {
                count++;
            } else {
                ListIterator<String> sItr = kStrings.listIterator();
                ListIterator<Integer> cItr = kCounts.listIterator();
                while (cItr.hasNext()) {
                    if (cItr.next() < count) {
                        cItr.previous();
                        break;
                    }
                    sItr.next();
                }
                cItr.add(count);
                sItr.add(previous);

                previous = words[i];
                count = 1;
            }
        }

        ListIterator<String> sItr = kStrings.listIterator();
        ListIterator<Integer> cItr = kCounts.listIterator();
        while (cItr.hasNext()) {
            if (cItr.next() < count) {
                cItr.previous();
                break;
            }
            sItr.next();
        }
        cItr.add(count);
        sItr.add(previous);

        return kStrings.subList(0, k);
    }
}