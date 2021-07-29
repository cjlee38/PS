package BOJ.tier.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/14916
 * name = 거스름돈
 * tier = silver 5
 * date = 2021-07-20, 화, 6:39
 */

public class bj14916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        Solution s = new Solution(n);
        bw.write(s.run() + "");

        bw.flush();
        br.close();
        bw.close();
    }

    static class Solution {
        private static final int MAX = 987654321;
        private int n;

        public Solution(int n) {
            this.n = n;
        }

        public int run() {
            if (n == 1 || n == 3)
                return -1;

            int[] dp = new int[100_000 + 1];
            dp[1] = dp[3] = MAX;
            dp[2] = dp[5] = 1;
            dp[4] = 2;
            for (int i = 6; i <= n; i++) {
                dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
            }
            return dp[n];
        }

    } // end of class
}