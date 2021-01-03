package BOJ.tier.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1080
 * name = 행렬
 * tier = silver 1
 */

public class bj1080 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = s.charAt(j) - '0';
            }
        }

        Solution s = new Solution(n, m, a, b);
        bw.write(s.run() + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int m;
        private int[][] a;
        private int[][] b;

        public Solution(int n, int m, int[][] a, int[][] b) {
            this.n = n;
            this.m = m;
            this.a = a;
            this.b = b;
        }

        public int run() {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != b[i][j]) {
                        if (flip(i, j)) count++;
                    }
                }
            }

            return same() ? count : -1;
        }

        private boolean flip(int y, int x) {
            if (y + 3 > n || x + 3 > m) return false;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    a[i + y][j + x] = 1 - a[i + y][j + x];
                }
            }

            return true;
        }

        private boolean same() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != b[i][j]) return false;
                }
            }

            return true;
        }

    } // end of class
}
