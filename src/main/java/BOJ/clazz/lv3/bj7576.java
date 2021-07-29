package BOJ.clazz.lv3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/7576
 * name = 토마토
 * tier = silver 1
 */

public class bj7576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] box = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution s = new Solution(x, y, box);
        bw.write(s.run() + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int x;
        private int y;
        private int[][] box;

        public Solution(int x, int y, int[][] box) {
            this.x = x;
            this.y = y;
            this.box = box;
        }

        public int run() {
            int ans = 0;
            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};

            Queue<Position> tomatoes = new LinkedList<>();

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (box[i][j] == 1) tomatoes.offer(new Position(j, i));
                }
            }

            while (!tomatoes.isEmpty()) {
                ans++;
                int size = tomatoes.size();
                for (int i = 0; i < size; i++) {
                    Position cur = tomatoes.poll();
                    for (int j = 0; j < 4; j++) {
                        int newX = cur.getX() + dx[j];
                        int newY = cur.getY() + dy[j];

                        ripe(tomatoes, newX, newY);
                    }
                }
            }

            return check() ? ans - 1 : -1;
        }


        private void ripe(Queue<Position> tomatoes, int x, int y) {
            if (range(x, y) && box[y][x] == 0) {
                tomatoes.offer(new Position(x, y));
                box[y][x] = 1;
            }
        }

        private boolean range(int x, int y) {
            return x >= 0 && y >= 0 && x < this.x && y < this.y;
        }

        private boolean check() {
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (box[i][j] == 0) return false;
                }
            }

            return true;
        }
    } // end of class

    static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
