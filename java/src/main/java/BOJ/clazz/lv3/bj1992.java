package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1992
 * name = 쿼드트리
 */

public class bj1992 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = split[j].equals("0") ? 0 : 1;
            }
        }

        Solution s = new Solution(n, board);
        bw.write(s.run() + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int[][] board;

        public Solution(int n, int[][] board) {
            this.n = n;
            this.board = board;
        }

        public String run() {
            StringBuilder sb = new StringBuilder();

            recursive(sb, n, 0, 0);

            return sb.toString();
        }

        public void recursive(StringBuilder sb, int size, int x, int y) {
            int val;
            if ((val = isSame(size, x, y)) != -1) {
                sb.append(val);
                return;
            }

            sb.append("(");
            size /= 2;

            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    recursive(sb, size, x + (size * j), y + (size * i));
                }
            }

            sb.append(")");
        }

        public int isSame(int size, int x, int y) {
            int std = board[y][x];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board[i + y][j + x] != std) return -1;
                }
            }

            return std;
        }

    } // end of class
}
