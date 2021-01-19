package BOJ.clazz.lv4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1149
 * name = RGB 거리
 * tier = silver 1
 */

public class bj1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][3];
        dp[0] = map[0];

        for (int i = 1; i < n; i++) {
            int a = dp[i - 1][0];
            int b = dp[i - 1][1];
            int c = dp[i - 1][2];
            dp[i][0] = Math.min(b, c) + map[i][0];
            dp[i][1] = Math.min(a, c) + map[i][1];
            dp[i][2] = Math.min(a, b) + map[i][2];
        }

        bw.write(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n- 1][2]) + "");
        bw.flush();
        bw.close();
    }

}
