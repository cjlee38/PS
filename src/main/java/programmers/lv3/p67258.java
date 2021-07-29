package programmers.lv3;

import java.util.*;
import java.util.stream.Collectors;

public class p67258 {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems = {"A", "B", "B", "C", "A", "B", "C"};
        int[] ans = sol.solution(gems);
        System.out.println(ans[0] + " " + ans[1]);
    }

    static class Solution {
        public int[] solution(String[] gems) {
            int[] answer = {0, Integer.MAX_VALUE};
            Set<String> uniqueGems = Arrays.stream(gems).collect(Collectors.toSet());
            Map<String, Integer> currentUniqueGems = new HashMap<>();
            int leftIndex = 0, rightIndex = 0;

            while (rightIndex < gems.length) {
                currentUniqueGems.compute(gems[rightIndex++], (k, v) -> v == null ? 1 : v + 1);
                if (currentUniqueGems.size() == uniqueGems.size()) {
                    while (leftIndex <= rightIndex) {
                        currentUniqueGems.compute(gems[leftIndex++], (k, v) -> v - 1);
                        if (currentUniqueGems.get(gems[leftIndex - 1]) <= 0) {
                            currentUniqueGems.remove(gems[leftIndex - 1]);
                            break;
                        }
                    }
                    if (answer[1] - answer[0] > rightIndex - leftIndex) {
                        answer[0] = leftIndex;
                        answer[1] = rightIndex;
                    }
                }

            }
            return answer;
        }
    }
}
