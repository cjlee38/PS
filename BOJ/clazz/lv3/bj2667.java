package BOJ.clazz.lv3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2667
 * name = 단지번호 붙이기
 * tier = silver 1
 */

public class bj2667 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Solution s = new Solution(n, map);
        List<Integer> answer = s.run();
        Collections.sort(answer);

        bw.write(answer.size() + "\n");
        for (Integer count : answer) {
            bw.write(count + "\n");
        }


        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int[][] map;

        public static final int[] dx = new int[]{-1, 0, 1, 0};
        public static final int[] dy = new int[]{0, -1, 0, 1};


        public Solution(int n, int[][] map) {
            this.n = n;
            this.map = map;
        }


        public List<Integer> run() {
            List<Integer> counts = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        counts.add(recursive(j, i));
                    }
                }
            }

            return counts;
        }

        private int recursive(int x, int y) {
            if (!range(x, y)) return 0;

            int count = 1;
            map[y][x] = 0;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                count += recursive(nextX, nextY);
            }

            return count;
        }

        private boolean range(int x, int y) {
            return x >= 0 && y >= 0 && x < n && y < n && map[y][x] != 0;
        }

    } // end of class
}
