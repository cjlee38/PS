package BOJ.tier.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10709
 * name = 기상캐스터
 * tier = silver 5
 * date = 2021-07-20, 화, 6:29
 */

public class bj10709 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = pInt(st);
        int w = pInt(st);
        int[][] map = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(map[i], -1);
            String row = br.readLine();
            for (int j = 0; j < w; j++) {
                if (row.charAt(j) == 'c')
                    map[i][j] = 0;
            }
        }

        Solution s = new Solution(map, h, w);
        int[][] ans = s.run();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bw.write(ans[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private int[][] map;
        private int h;
        private int w;

        public Solution(int[][] map, int h, int w) {
            this.map = map;
            this.h = h;
            this.w = w;
        }

        public int[][] run() {
            for (int i = 0 ; i < h; i++)
                flow(map[i]);

            return map;
        }

        private void flow(int[] row) {
            for (int i = 1; i < w; i++) {
                if (row[i] == -1 && row[i - 1] != -1)
                    row[i] = row[i - 1] + 1;
            }
        }

    } // end of class
}

