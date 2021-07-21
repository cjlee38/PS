package BOJ.tier.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/14495
 * name = 피보나치 비스무리한 수열
 * tier = silver 3
 * date = 2021-07-22, 목, 8:2
 */

public class bj14495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[116 + 1];
        dp[1] = dp[2] = dp[3] = 1;
        for (int i = 4; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 3];

        bw.write(dp[n] + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        public int run() {

            return -1;
        }

    } // end of class
}

