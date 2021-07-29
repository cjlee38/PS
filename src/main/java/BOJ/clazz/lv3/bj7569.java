package BOJ.clazz.lv3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/7569
 * name = 토마토
 * tier = silver 1
 */

public class bj7569 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        int[][][] box = new int[z][y][x];

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < x; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Solution s = new Solution(x, y, z, box);
        bw.write(s.run() + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int x;
        private int y;
        private int z;
        private int[][][] box;

        public Solution(int x, int y, int z, int[][][] box) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.box = box;
        }

        public int run() {
            int ans = 0;
            int[] dz = new int[]{-1, 1, 0, 0, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1, 0, 0};
            int[] dx = new int[]{0, 0, 0, 0, -1, 1};

            Queue<Position> tomatoes = new LinkedList<>();

            for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        if (box[i][j][k] == 1) tomatoes.offer(new Position(k, j, i));
                    }
                }
            }

            while (!tomatoes.isEmpty()) {
                ans++;
                int size = tomatoes.size();
                for (int i = 0; i < size; i++) {
                    Position pos = tomatoes.poll();
                    for (int j = 0; j < 6; j++) {
                        int newX = pos.getX() + dx[j];
                        int newY = pos.getY() + dy[j];
                        int newZ = pos.getZ() + dz[j];

                        ripe(tomatoes, newX, newY, newZ);
                    }
                }
            }

            return check() ? ans - 1 : -1;
        }

        private void print() {
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        System.out.print(box[i][j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println("------------------");
            }
            System.out.println("===============");
        }

        private void ripe(Queue<Position> tomatoes, int x, int y, int z) {
            if (range(x, y, z) && box[z][y][x] == 0) {
                tomatoes.offer(new Position(x, y, z));
                box[z][y][x] = 1;
            }
        }

        private boolean range(int x, int y, int z) {
            return x >= 0 && y >= 0 && z >= 0 && x < this.x && y < this.y && z < this.z;
        }

        private boolean check() {
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        if (box[i][j][k] == 0) return false;
                    }
                }
            }

            return true;
        }
    } // end of class

    static class Position {
        private final int x;
        private final int y;
        private final int z;

        public Position(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }
}
