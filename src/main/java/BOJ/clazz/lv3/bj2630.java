package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2630
 * name = 색종이 만들기
 * tier = silver 3
 */

public class bj2630 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution s = new Solution(n, paper);
        int[] answer = s.run();
        bw.write(answer[0] + "\n" + answer[1]);
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int[][] paper;

        public static final int WHITE = 0;
        public static final int BLUE = 1;

        public Solution(int n, int[][] paper) {
            this.n = n;
            this.paper = paper;
        }

        public int[] run() {
            int[] counts = new int[2]; // white, color
            cut(counts, n, 0, 0);

            return counts;
        }

        private void cut(int[] counts, int size, int x, int y) {
            int color;
            if ((color = same(size, x, y)) != -1) {
                counts[color]++;
                return;
            }

            size /= 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    cut(counts, size, x + (j * size), y + (i * size));
                }
            }
        }

        private int same(int size, int x, int y) {
            int val = paper[y][x];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (val != paper[i + y][j + x]) return -1;
                }
            }

            return val;
        }

    } // end of class
}
