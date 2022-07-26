package BOJ.clazz.lv4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/12865
 * name = 평범한 배낭
 * tier = gold 5
 */

public class bj12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        Solution s = new Solution(n, k, w, v);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int k;
        private int[] w;
        private int[] v;

        public Solution(int n, int k, int[] w, int[] v) {
            this.n = n;
            this.k = k;
            this.w = w;
            this.v = v;
        }

        public int run() {
            int[][] dp = new int[n + 1][k + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    if (w[i - 1] <= j)
                        dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
            return dp[n][k];
        }

    } // end of class
}

