package problems.p831;

class Solution {
    public String maskPII(String S) {
        if (S.contains("@")) {
            return S.toLowerCase().replaceAll("^(.).*(.@.*)$", "$1*****$2");
        } else {
            S = S.replaceAll("[()\\-+ ]", "");
            if (S.length() > 10) {
                return "+" + S.substring(0, S.length() - 10).replaceAll(".", "*")
                        + S.replaceAll("^.+([0-9]{4})$", "-***-***-$1");
            } else {
                return S.replaceAll("^.+([0-9]{4})$", "***-***-$1");
            }
        }
    }
}