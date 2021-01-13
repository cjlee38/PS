package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11727
 * name = 2 x n 타일링 2
 * tier = silver 3
 */

public class bj11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write("1");
        } else {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 3;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
            }
            bw.write(dp[n] + "");
        }

        bw.flush();
        bw.close();
    }

    static class Solution {

        public int run() {

            return -1;
        }

    } // end of class
}
