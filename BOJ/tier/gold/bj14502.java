package BOJ.tier.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/14502
 * name = 연구소
 * tier = gold 5
 * date = 2021-07-15, 목, 10:32
 */

public class bj14502 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = pInt(st);
        int m = pInt(st);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = pInt(st);
            }
        }

        Solution s = new Solution(map, n, m);
        bw.write(s.run() + "");


        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private static final int[] DX = {0, 1, 0, -1};
        private static final int[] DY = {-1, 0, 1, 0};

        private int[][] map;
        private int n;
        private int m;

        private int ans = -1;

        public Solution(int[][] map, int n, int m) {
            this.map = map;
            this.n = n;
            this.m = m;
        }

        public int run() {
            dfs(0);
            return ans;
        }

        private void dfs(int depth) {
            if (depth == 3) {
                bfs();
                return ;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        dfs(depth + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }

        private void bfs() {
            int[][] copied = copy();
            Queue<Virus> Q = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copied[i][j] == 2)
                        Q.add(new Virus(j, i));
                }
            }

            while (!Q.isEmpty()) {
                Virus poll = Q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = poll.x + DX[i];
                    int ny = poll.y + DY[i];
                    if (isInRange(nx, ny) && copied[ny][nx] == 0) {
                        copied[ny][nx] = 2;
                        Q.offer(new Virus(nx, ny));
                    }
                }
            }
            measureSafeArea(copied);
        }

        private void measureSafeArea(int[][] copied) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copied[i][j] == 0)
                        count++;
                }
            }
            ans = Math.max(ans, count);
        }

        private int[][] copy() {
            int[][] copied = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0 ; j < m; j++) {
                    copied[i][j] = map[i][j];
                }
            }
            return copied;
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < m && y < n;
        }

    } // end of class

    static class Virus {

        private int x;
        private int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}

