package programmers.lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p77484 {
    public static void main(String[] args) {
        int[] lottos = new int[]{44, 1, 0, 0, 31, 25};
        int[] win_nums = new int[]{ 31, 10, 45, 1, 6, 19 };
        Solution sol = new Solution();
        int[] ans = sol.solution(lottos, win_nums);
        System.out.println(ans[0] + " " + ans[1]);

    }

    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            List<Integer> lottoSet = Arrays.stream(lottos).boxed().collect(Collectors.toList());
            List<Integer> winNumset = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

            long numOfZeros = lottoSet.stream().filter(x -> x == 0).count();
            lottoSet.retainAll(winNumset);

            answer[0] = rankByWinCount((int) (lottoSet.size() + numOfZeros));
            answer[1] = rankByWinCount(lottoSet.size());

            return answer;
        }

        private int rankByWinCount(int winCount) {
            if (winCount >= 2)
                return 7 - winCount;
            return 6;
        }
    }
}
