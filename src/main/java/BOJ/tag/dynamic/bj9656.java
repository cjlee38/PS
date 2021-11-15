package BOJ.tag.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/9656
 * name = 돌 게임 2
 * tier = silver 4
 * date = 2021-11-15, 월, 22:38
 */

public class bj9656 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            int n = bInt(br);
            Solution s = new Solution(n);
            String res = s.run();
            bw.write(res);


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

        public String run() {
            int[] dp = new int[1001];
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 0;
            for (int i = 4; i <= n; i++) {
                if (dp[i - 1] == 0 || dp[i - 3] == 0) dp[i] = 1;
                else dp[i] = 0;
            }
            return dp[n] == 1 ? "SK" : "CY";
        }

    } // end of class
}

