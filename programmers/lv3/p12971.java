package programmers.lv3;

/**
 * uri = https://programmers.co.kr/learn/courses/30/lessons/12971?language=java
 * name = 스티커 모으기(2)
 */

public class p12971 {
    public static void main(String[] args) {
        int[] sticker = new int[]{14, 6, 5, 11, 3, 9, 2, 10};

        Solution s = new Solution();
        int ans = s.solution(sticker);
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int sticker[]) {
            if (sticker.length == 1)
                return sticker[0];
            int dp1[] = new int[sticker.length];
            int dp2[] = new int[sticker.length];

            dp1[0] = sticker[0];
            dp1[0] = sticker[0];

            dp2[0] = 0;
            dp2[1] = sticker[1];
            for (int i = 2; i < sticker.length; i++) {
                dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
                dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
            }

            return Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);
        }
    }
}
