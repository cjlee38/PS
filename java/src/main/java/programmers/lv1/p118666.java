package programmers.lv1;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p118666 {

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = new int[]{5, 3, 2, 7, 5};
        Solution s = new Solution();
        String result = s.solution(survey, choices);
        System.out.println("result = " + result);
    }

    static class Solution {

        private static final int MIDDLE = 4;

        public String solution(String[] survey, int[] choices) {
            Map<Character, Integer> scores = createDefaultScores();
            for (int i = 0; i < survey.length; i++) {
                String s = survey[i];
                int choice = choices[i];
                if (choice == MIDDLE) {
                    continue;
                }
                int score = Math.abs(choice - MIDDLE);
                char c = choice < MIDDLE ? s.charAt(0) : s.charAt(1);
                scores.compute(c, (k, v) -> v == null ? score : v + score);
            }
            StringBuilder sb = new StringBuilder();
            List<String> inds = List.of("RT", "CF", "JM", "AN");
            for (String ind : inds) {
                sb.append(finish(scores, ind));
            }
            return sb.toString();
        }

        private Map<Character, Integer> createDefaultScores() {
            return List.of('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')
                    .stream()
                    .collect(Collectors.toMap(Function.identity(), it -> 0));
        }

        private char finish(Map<Character, Integer> scores, String it) {
            char leftKey = it.charAt(0);
            Integer left = scores.get(leftKey);
            char rightKey = it.charAt(1);
            Integer right = scores.get(rightKey);
            if (left == right) {
                return leftKey < rightKey ? leftKey : rightKey;
            }
            return left > right ? leftKey : rightKey;
        }
    }
}
