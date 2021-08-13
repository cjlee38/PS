package codetree.intermediate.low.dp.string;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestCommonSequence {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();
        Solution s = new Solution(s1, s2);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    public static int[] getArray(int n) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    public static int[][] get2ndArray(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }

    static class Solution {

        private String s1;
        private String s2;

        public Solution(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        public int run() {
            int[][] dp = new int[s1.length()][s2.length()];
            init(dp);
            for (int i = 1; i < s1.length(); i++) {
                for (int j = 1; j < s2.length(); j++) {
                    dp[i][j] = s1.charAt(i) == s2.charAt(j) ?
                            dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            return dp[s1.length() - 1][s2.length() - 1];
        }

        private void print(int[][] dp) {
            for (int i = 0; i < s1.length(); i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
        }

        private void init(int[][] dp) {
            dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
            for (int i = 1; i < s1.length(); i++)
                dp[i][0] = s1.charAt(i) == s2.charAt(0) ? 1 : dp[i - 1][0];
            for (int i = 1; i < s2.length(); i++)
                dp[0][i] = s1.charAt(0) == s2.charAt(i) ? 1 : dp[0][i - 1];
        }

    }
}
