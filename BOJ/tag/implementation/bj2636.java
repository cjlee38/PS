package BOJ.tag.implementation;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2636
 * name = 치즈
 * tier = gold 5
 * date = 2021-07-25, 일, 22:27
 */

public class bj2636 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = pInt(st);
        int w = pInt(st);
        int[][] board = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = pInt(st);
            }
        }
        Solution s = new Solution(board, h, w);
        int[] ans = s.run();
        bw.write(ans[0] + "\n" + ans[1]);

        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {
        private static final int AIR = 0;
        private static final int CHEESE = 1;
        private static final int dlen = 4;
        private static final int[] dx = new int[]{0, 1, 0, -1};
        private static final int[] dy = new int[]{-1, 0, 1, 0};

        private int[][] board;
        private int h;
        private int w;

        public Solution(int[][] board, int h, int w) {
            this.board = board;
            this.h = h;
            this.w = w;
        }

        public int[] run() {
            int time = 0;
            int curNumOfCheese = 0;
            int prevNumOfCheese = 0;
            while ((curNumOfCheese = countNumOfCheese()) != 0) {
                meltDown();
                prevNumOfCheese = curNumOfCheese;
                time++;
            }

            return new int[]{time, prevNumOfCheese};
        }

        private void meltDown() {
            boolean[][] visited = new boolean[h][w];
            boolean[][] marker = new boolean[h][w];
            Queue<Position> Q = new LinkedList<>();
            offerEdges(Q, visited);

            while (!Q.isEmpty()) {
                Position poll = Q.poll();


                for (int i = 0; i < dlen; i++) {
                    int nx = poll.x + dx[i];
                    int ny = poll.y + dy[i];

                    if (isInRange(nx, ny) && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        if (isAir(board[ny][nx])) Q.offer(new Position(nx, ny));
                        else marker[ny][nx] = true;
                    }
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (marker[i][j]) board[i][j] = 0;
                }
            }
        }

        private void offerEdges(Queue<Position> Q, boolean[][] visited) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (isEdge(j, i)) {
                        Q.offer(new Position(j, i));
                        visited[i][j] = true;
                    }
                }
            }
        }

        private boolean isEdge(int x, int y) {
            return x == 0 || x == w - 1 || y == 0 || y == h - 1;
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < w && y < h;
        }

        private boolean isAir(int v) {
            return v == AIR;
        }

        private int countNumOfCheese() {
            return Arrays.stream(board)
                    .mapToInt(x -> Arrays.stream(x).sum())
                    .sum();
        }
    } // end of class

    static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

