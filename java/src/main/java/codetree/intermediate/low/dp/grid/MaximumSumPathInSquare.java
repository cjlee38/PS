package codetree.intermediate.low.dp.grid;

import java.io.*;
import java.util.StringTokenizer;

public class MaximumSumPathInSquare {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] grid = get2ndArray(n, n);
        Solution s = new Solution(n, grid);
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

        private int n;
        private int[][] grid;

        public Solution(int n, int[][] grid) {
            this.n = n;
            this.grid = grid;
        }

        public int run() {
            int[][] dp = new int[n][n];
            init(dp);
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[n - 1][n - 1];
        }

        private void init(int[][] dp) {
            dp[0][0] = grid[0][0];
            for (int i = 1; i < n; i++)
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            for (int i = 1; i < n; i++)
                dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
    }
}
