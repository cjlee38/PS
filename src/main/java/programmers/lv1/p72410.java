package programmers.lv1;

import java.util.Locale;

public class p72410 {
    public static void main(String[] args) {
        String s1 = "...!@BaT#*..y.abcdefghijklm";
        Solution s = new Solution();

        String res = s.solution(s1);
        System.out.println(res);
    }

    static class Solution {
        public String solution(String new_id) {
            return rule7(rule6(rule5(rule4(rule3(rule2(rule1(new_id)))))));
        }

        private String rule1(String old) {
            return old.toLowerCase(Locale.ROOT);
        }

        private String rule2(String old) {
            return old.replaceAll("[^a-z0-9-_.]", "");
        }

        private String rule3(String old) {
            return old.replaceAll("[.]{2,}", ".");
        }

        private String rule4(String old) {
            return old.replaceAll("^[.]|[.]$", "");
        }

        private String rule5(String old) {
            return old.length() == 0 ? "a" : old;
        }

        private String rule6(String old) {
            return old.length() < 16 ? old : old.substring(0, 15).replaceAll("[.]$", "");
        }

        private String rule7(String old) {
            StringBuilder oldBuilder = new StringBuilder(old);
            while (oldBuilder.length() <= 2) {
                oldBuilder.append(oldBuilder.charAt(oldBuilder.length() - 1));
            }
            return oldBuilder.toString();
        }
    }
}
