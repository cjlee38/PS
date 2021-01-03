package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2579
 * name = 계단 오르기
 */

public class bj2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        Solution s = new Solution(n, stairs);
        bw.write(s.run() + "");


        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int[] stairs;

        public Solution(int n, int[] stairs) {
            this.n = n;
            this.stairs = stairs;
        }

        public int run() {
            if (n == 1) return stairs[1];

            int[] dp = new int[n + 1];
            dp[1] = stairs[1];
            dp[2] = stairs[1] + stairs[2];

            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(
                        dp[i - 2], dp[i - 3] + stairs[i - 1]
                ) + stairs[i];
            }


            return dp[n];
        }

    } // end of class

}
