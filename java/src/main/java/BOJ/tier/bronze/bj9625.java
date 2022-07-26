package BOJ.tier.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/9625
 * name = BABBA
 * tier = bronze 1
 * date = 2021-07-20, 화, 6:16
 */

public class bj9625 {

    private static final int DP_MAX = 46;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[DP_MAX][2];
        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};
        for (int i = 2; i < DP_MAX; i++) {
            dp[i] = new int[]{
                    dp[i - 2][0] + dp[i - 1][0],
                    dp[i - 2][1] + dp[i - 1][1]
            };
        }
        bw.write(dp[n][0] + " " + dp[n][1]);

        bw.flush();
        br.close();
        bw.close();
    }
}
