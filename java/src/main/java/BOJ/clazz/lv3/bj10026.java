package BOJ.clazz.lv3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10026
 * name = 적록색약
 * tier = gold 5
 */

public class bj10026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] draw = new char[n][n];
        for (int i = 0; i < n; i++) {
            draw[i] = br.readLine().toCharArray();
        }


        Solution s = new Solution(n, draw);
        int[] answer = s.run();
        bw.write(answer[0] + "\n" + answer[1] + "\n");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private char[][] draw;


        private int[] dx = new int[]{-1, 1, 0, 0};
        private int[] dy = new int[]{0, 0, -1, 1};

        public Solution(int n, char[][] draw) {
            this.n = n;
            this.draw = draw;
        }

        public int[] run() {
            return new int[]{getNumOfAreas(false), getNumOfAreas(true)};
        }

        private int getNumOfAreas(boolean isBlind) {
            boolean[][] visited = new boolean[n][n];
            int num = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(visited, j, i, isBlind);
                        num++;
                    }
                }
            }

            return num;
        }

        private void bfs(boolean[][] visited, int x, int y, boolean isBlind) {
            Queue<Position> Q = new LinkedList<>();
            Q.offer(new Position(x, y));
            visited[y][x] = true;
            char color = draw[y][x];

            while (!Q.isEmpty()) {
                int size = Q.size();

                for (int i = 0; i < size; i++) {
                    Position cur = Q.poll();
                    int curX = cur.getX();
                    int curY = cur.getY();


                    for (int j = 0; j < 4; j++) {
                        int newX = curX + dx[j];
                        int newY = curY + dy[j];
                        if (isInRange(newX, newY) && !visited[newY][newX] && isSameColor(color, newX, newY, isBlind)) {
                            visited[newY][newX] = true;
                            Q.offer(new Position(newX, newY));
                        }
                    }
                }
            }
        }

        private boolean isSameColor(char color, int x, int y, boolean isBlind) {
            if (!isBlind) return color == draw[y][x];
            else return ((color == 'R' || color == 'G') && (draw[y][x] == 'R' || draw[y][x] == 'G')) || (color == 'B' && draw[y][x] == 'B');
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < n && y < n;
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
