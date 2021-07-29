package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/18111
 * name = 마인크래프트
 */

public class bj18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
                min = Math.min(min, cur);
                max = Math.max(max, cur);
            }
        }

        Solution s = new Solution(n, m, b, map);
        int[] result = s.run(min, max);
        bw.write(result[0] + " " + result[1] + "\n");


        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int m;
        private int b;
        private int[][] map;

        public Solution(int n, int m, int b, int[][] map) {
            this.n = n;
            this.m = m;
            this.b = b;
            this.map = map;
        }

        public int[] run(int min, int max) {
            int anstime = Integer.MAX_VALUE;
            int ansheight = Integer.MIN_VALUE;


            for (int height = min; height <= max; height++) {
                int time = 0;
                int block = b;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int diff = map[i][j] - height;
                        if (diff >= 0) {
                            time += diff * 2;
                            block += diff;
                        } else {
                            time -= diff;
                            block += diff;
                        }
                    }
                }

                if (block < 0) continue;
                if (time <= anstime) {
                    anstime = time;
                    ansheight = height;
                }

            }
            return new int[]{anstime, ansheight};
        }
    }
}
