package BOJ.clazz.lv4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2448
 * name = 별찍기 11
 * tier = gold 4
 */

public class bj2448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][2 * n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], ' ');
        }

        Solution s = new Solution(n, map);
        char[][] ret = s.run();

        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) {
                bw.write(ret[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private char[][] map;

        public Solution(int n, char[][] map) {
            this.n = n;
            this.map = map;
        }

        public char[][] run() {
            find(0, n - 1, n);
            return map;
        }

        private void find(int a, int b, int n) {
            if (n == 3) {
                draw(a, b);
                return;
            }

            n /= 2;
            find(a, b, n); // 위
            find(a + n, b - n, n);
            find(a + n, b + n, n);
        }

        private void draw(int a, int b) {
            map[a][b] = '*';
            map[a + 1][b - 1] = map[a + 1][b + 1] = '*';
            map[a + 2][b - 2] = map[a + 2][b - 1] = map[a + 2][b] = map[a + 2][b + 1] = map[a + 2][b + 2] = '*';
        }

    } // end of class
}
