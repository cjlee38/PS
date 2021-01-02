package BOJ.clazz.lv3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2178
 * name = 미로 탐색
 */

public class bj2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] miro = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                miro[i][j] = split[j].equals("0") ? 0 : 1;
            }
        }

        Solution s = new Solution(N, M, miro);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int N;
        private int M;
        private int[][] miro;

        public Solution(int n, int m, int[][] miro) {
            N = n;
            M = m;
            this.miro = miro;
        }

        public int run() {
            int count = 1;
            Queue<Position> Q = new LinkedList<>();
            int[] dx = new int[]{-1, 0, 1, 0};
            int[] dy = new int[]{0, -1, 0, 1};
            boolean[][] visited = new boolean[N][M];

            Q.add(new Position(0, 0));
            visited[0][0] = true;

            b: while (!Q.isEmpty()) {
                int size = Q.size();
                count++;

                for (int q = 0; q < size; q++) {
                    Position cur = Q.poll();
//                    if (cur.getX() == M - 1 && cur.getY() == N - 1) break b;
                    for (int i = 0; i < 4; i++) {
                        int newX = cur.getX() + dx[i];
                        int newY = cur.getY() + dy[i];

                        if (possible(newX, newY) && !visited[newY][newX]) {
                            if (newX == M - 1 && newY == N - 1) break b;
                            Q.add(new Position(newX, newY));
                            visited[newY][newX] = true;
                        }
                    }
                }

//                count++;
            }

            return count;
        }

        private boolean possible(int x, int y) {
            /* out of range */
            if (x < 0 || y < 0 || x >= M || y >= N) return false;
            return miro[y][x] != 0;

        }

    } // end of class

    static class Position {
        private int x;
        private int y;

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
