package BOJ.tag.implementation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2573
 * name = 빙산
 * tier = gold 4
 * date = 2021-07-29, 목, 20:3
 */

public class bj2573 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = pInt(st);
        int m = pInt(st);
        int[][] map = new int[n][m];
        for (int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = pInt(st);
            }
        }

        Solution s = new Solution(n, m, map);
        bw.write(s.run() + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {
        private static final int DLEN = 4;
        private static final int[] DX = new int[]{0, 1, 0, -1};
        private static final int[] DY = new int[]{-1, 0, 1, 0};

        private int n;
        private int m;
        private int[][] map;

        public Solution(int n, int m, int[][] map) {
            this.n = n;
            this.m = m;
            this.map = map;
        }

        public int run() {
            int years = 0;
            int numOfIcebergUnion = 0;
            while ((numOfIcebergUnion = getIcebergUnion()) == 1) {
                passYears();
                years++;
            }

            return numOfIcebergUnion == 0 ? 0 : years;
        }

        private void passYears() {
            int[][] temp = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0)
                        temp[i][j] = getMeltAmount(i, j);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] -= temp[i][j];
                }
            }
        }

        private int getMeltAmount(int y, int x) {
            int amount = 0;
            for (int i = 0; i < DLEN; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (isInRange(nx, ny) && map[ny][nx] <= 0)
                    amount++;
            }
            return amount;
        }

        private int getIcebergUnion() {
            int numOfUnion = 0;
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        numOfUnion++;
                        dfs(visited, i, j);
                    }
                }
            }
            return numOfUnion;
        }

        private void dfs(boolean[][] visited, int y, int x) {
            visited[y][x] = true;

            for (int i = 0; i < DLEN; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (isInRange(nx, ny) && !visited[ny][nx] && map[ny][nx] > 0)
                    dfs(visited, ny, nx);
            }
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && y < n && x < m;
        }

    } // end of class
}

