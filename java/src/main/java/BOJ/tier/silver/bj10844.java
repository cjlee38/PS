package BOJ.tier.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10844
 * name = 쉬운 계단수
 * tier = silver 1
 * date = 2021-11-15, 월, 22:19
 */

public class bj10844 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            int n = bInt(br);
            Solution s = new Solution(n);
            long res = s.run();
            bw.write(res + "");


            // == done == //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static StringTokenizer tokenize(BufferedReader br) throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static int bInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int sInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private int n;

        public Solution(int n) {
            this.n = n;
        }

        public long run() {
            if (n == 1)
                return 9;
            long[][] dp = new long[n + 1][11];
            for (int i = 1; i <= 9; i++) {
                dp[1][i] = 1;
            }

            for (int i = 2; i <= n; i++) {
                dp[i][0] = dp[i - 1][1];
                for (int j = 1; j <= 9; j++) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
                }
            }

            for (int i = 0; i < dp.length; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
            return Arrays.stream(dp[n]).sum() % 1_000_000_000;
        }

    } // end of class
}

