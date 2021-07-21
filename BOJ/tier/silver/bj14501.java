package BOJ.tier.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/14501
 * name = 퇴사
 * tier = silver 4
 * date = 2021-07-20, 화, 14:53
 */

public class bj14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = pInt(st);
            arr[i][1] = pInt(st);
        }

        Solution s = new Solution(arr, n);
        bw.write(s.run() + "");


        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private int[][] arr;
        private int n;

        public Solution(int[][] arr, int n) {
            this.arr = arr;
            this.n = n;
        }

        public int run() {
            int[] dp = new int[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i][0] + i > n) { // if not in bound
                    dp[i] = dp[i + 1];
                } else {
                    dp[i] = Math.max(dp[i + 1], dp[arr[i][0] + i] + arr[i][1]);
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }

    } // end of class
}

