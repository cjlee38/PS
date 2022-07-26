package programmers.lv3;

import java.util.Arrays;

public class p64062 {
    public static void main(String[] args) {
        int[] stones = new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        Solution s = new Solution();
        int ans = s.solution(stones, k);
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int[] stones, int k) {
            int min = 1, max = 200000000, ans = 0;

            while (min <= max) {
                int mid = (min + max) / 2;
                if (canCross(stones, k, mid)) {
                    min = mid + 1;
                    ans = Math.max(ans, mid);
                } else {
                    max = mid - 1;
                }
            }
            return ans;
        }

        private boolean canCross(int[] stones, int k, int mid) {
            int cnt = 0;

            for (int stone : stones) {
                if (stone < mid)
                    cnt++;
                else
                    cnt = 0;
                if (cnt == k)
                    return false;
            }
            return true;
        }
    }
}
