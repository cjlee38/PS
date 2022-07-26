package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1780
 * name = 종이의 개수
 */

public class bj1780 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution s = new Solution(n, board);
        int[] answer = s.run();

        for (int i : answer) {
            bw.write(i + "\n");
        }
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

        public int[] run() {

            int[] answer = new int[3];
            int size = n;
            recursive(answer, size, 0, 0);


            return answer;
        }

        public void recursive(int[] answer, int size, int x, int y) {
            if (same(size, x, y)) {
                answer[board[y][x] + 1]++;
                return;
            }

            /* split */
            size /= 3;

            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    recursive(answer, size, x + (j * size), y + (i * size));
                }
            }


        }

        public boolean same(int size, int x, int y) {
            if (size == 1) return true;

            int val = board[y][x];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (val != board[j + y][i + x]) return false;
                }
            }

            return true;
        }
    }
}
