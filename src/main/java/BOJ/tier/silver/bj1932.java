package BOJ.tier.silver;

import java.io.*;
import java.util.Arrays;

/**
 * uri = https://www.acmicpc.net/problem/1932
 * name = 정수 삼각형
 * tier = silver 1
 */

public class bj1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][n];
        for (int i = 0; i < n; i++) {
            tri[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Solution s = new Solution(n, tri);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int[][] tri;

        public Solution(int n, int[][] tri) {
            this.n = n;
            this.tri = tri;
        }

        public int run() {
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0) tri[i][j] += tri[i - 1][j];
                    else if (j == i) tri[i][j] += tri[i - 1][j - 1];
                    else tri[i][j] += Math.max(tri[i - 1][j], tri[i - 1][j - 1]);
                }
            }

            return getMaxInRow(tri[n - 1]);
        }

        public int getMaxInRow(int[] row) {
            return Arrays.stream(row).max().getAsInt();
        }
    } // end of class
}
