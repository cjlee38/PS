package BOJ.tier.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1904
 * name = 01타일
 * tier = silver 3
 * date = 2021-07-22, 목, 8:11
 */

public class bj1904 {

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

        private int n;

        public Solution(int n) {
            this.n = n;
        }

        public int run() {
            int[] dp = new int[n <= 2 ? 3 : n + 1];
            dp[0] = 0; dp[1] = 1; dp[2] = 2;
            for (int i = 3; i <= n; i++)
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            return dp[n];
        }

    } // end of class
}

