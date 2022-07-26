package _hidden.toss;

import java.util.*;
import java.util.stream.Collectors;

public class p1 {

    public static void main(String[] args) {
        String s1 = "aAb";
        String s2 = "BA";
        String s3 = "BbA";
        String s4 = "aaBBTtooSS";

        Solution s = new Solution();
        System.out.println(s.solution(s1));
        System.out.println(s.solution(s2));
        System.out.println(s.solution(s3));
        System.out.println(s.solution(s4));
    }

    static class Solution {

        private static final int ASCII_S = 115;
        private static final int ASCII_O = 111;
        private static final int ASCII_T = 116;

        public String solution(String param0) {
            StringBuilder sb = new StringBuilder();
            char[] chars = convert(param0);
            int[] alphas = new int[26];
            for (char c : chars) {
                alphas[c - 97]++;
            }
            int max = Arrays.stream(alphas).max().getAsInt();
            for (int i = 0; i < alphas.length; i++) {
                if (isSpecialCase(i)) continue;
                if (alphas[i] == max) sb.append((char)(i + 97));
            }
            if (alphas[ASCII_S - 97] == max) sb.insert(0, "SS");
            if (alphas[ASCII_O - 97] == max) sb.insert(0, "O");
            if (alphas[ASCII_T - 97] == max) sb.insert(0, "T");
            return sb.toString();
        }

        private boolean isSpecialCase(int v) {
            int i = v + 97;
            return i == ASCII_T || i == ASCII_O || i == ASCII_S;
        }

        private char[] convert(String param0) {
            return param0.toLowerCase(Locale.ROOT).toCharArray();
        }
    }
}
