package BOJ.tier.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1912
 * name = 연속 합
 * tier = silver 2
 * date = 2021-11-13, 토, 23:29
 */

public class bj1912 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            int n = bInt(br);
            st = tokenize(br);
            int[] arr = new int[n];
            for (int i = 0;i < n; i++)
                arr[i] = sInt(st);
            Solution s = new Solution(n, arr);
            int res = s.run();
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
        private int[] arr;

        public Solution(int n, int[] arr) {
            this.n = n;
            this.arr = arr;
        }

        public int run() {
            int[] dp = new int[n];
            dp[0] = arr[0];
            int ans = dp[0];

            for (int i = 1; i < n; i++){
                dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }

    } // end of class
}

