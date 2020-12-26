package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1012
 * name = 유기농 배추
 */

public class bj1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken()); // width
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            Solution s = new Solution(n, m, k, map);
            bw.write(s.run() + "\n");
        }

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int h;
        private int w;
        private int k;
        private int[][] map;

        public Solution(int h, int w, int k, int[][] map) {
            this.h = h;
            this.w = w;
            this.k = k;
            this.map = map;
        }

        public int run() {

            int ans = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        recursive(i, j);
                        ans++;
                    }
                }
            }

            return ans;
        }

        private void recursive(int y, int x) {
            // is out of range?
            if (x < 0 || x >= w || y < 0 || y >= h) return;

            // is this position 0 ?
            if (map[y][x] == 0) return;

            map[y][x] = 0;

            recursive(y - 1, x);
            recursive(y + 1, x);
            recursive(y, x - 1);
            recursive(y, x + 1);

        }
    }
}
