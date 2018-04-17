package problems.p811;

import java.util.*;

class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String cp : cpdomains) {
            String[] domain = cp.trim().replaceAll("  +", " ").split(" ");
            int count = Integer.parseInt(domain[0]);

            int index = 0;
            do {
                index = domain[1].indexOf(".", index) + 1;
                String sd = domain[1].substring(index, domain[1].length());
                Integer ct = counts.get(sd);
                if (ct == null) {
                    ct = count;
                } else {
                    ct += count;
                }
                counts.put(sd, ct);
            } while (index > 0);
        }

        List<String> results = new ArrayList<>(counts.size());

        Set<Map.Entry<String, Integer>> entries = counts.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            results.add(entry.getValue() + " " + entry.getKey());
        }

        return results;
    }
}