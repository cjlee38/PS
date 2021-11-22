package BOJ.tag.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2193
 * name = 이친수
 * tier = silver 3
 * date = 2021-11-22, 월, 21:3
 */

public class bj2193 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            int n = bInt(br);
            Solution s = new Solution(n);
            bw.write(s.run() + "");

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

            long dp[] = new long[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }

    } // end of class
}

