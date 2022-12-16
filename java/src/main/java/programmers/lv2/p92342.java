package programmers.lv2;

import java.util.Arrays;

public class p92342 {
    public static void main(String[] args) {
//        int n = 5;
//        int[] info = new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
//        int n = 10;
//        int[] info = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int n = 9;
        int[] info = new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        Solution s = new Solution();
        int[] result = s.solution(n, info);
        System.out.println(Arrays.toString(result));
    }

    private static class Solution {

        private static final int SIZE = 11;

        private int maxDiff = -1;
        private int[] ans = null;

        public int[] solution(int n, int[] info) {
            int[] shots = new int[SIZE];
            run(n, info, shots, 0);
            return ans == null ? new int[]{-1} : ans;
        }

        private void run(int n, int[] info, int[] shots, int index) {
            if (n <= 0 || index >= info.length) {
                int diff = calculateScoreDiff(info, shots);
                if (diff <= 0) {
                    return;
                }
                if (diff > maxDiff) {
                    ans = Arrays.copyOf(shots, SIZE);
                    maxDiff = diff;
                } else if (diff == maxDiff) {
                    for (int i = SIZE - 1; i >= 0; i--) {
                        if (ans[i] < shots[i]) {
                            ans = Arrays.copyOf(shots, SIZE);
                            maxDiff = diff;
                            break;
                        } else if (ans[i] > shots[i]) {
                            break;
                        }
                    }
                }
                return;
            }
            for (int i = index; i < info.length; i++) {
                shots[i]++;
                run(n - 1, info, shots, i);
                shots[i]--;
            }
        }

        private int calculateScoreDiff(int[] info, int[] shots) {
            int apeach = 0, lion = 0;
            for (int i = 0; i < SIZE; i++) {
                if (info[i] == 0 && shots[i] == 0) {
                    continue;
                }
                if (info[i] >= shots[i]) {
                    apeach += (10 - i);
                } else {
                    lion += (10 - i);
                }
            }
            return lion - apeach;
        }
    }
}
