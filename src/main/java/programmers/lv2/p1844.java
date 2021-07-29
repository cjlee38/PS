package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class p1844 {
    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        Solution s = new Solution();
        int res = s.solution(maps);
        System.out.println(res);
    }

    static class Solution {
        private int rows;
        private int cols;
        private boolean[][] visited;

        public int solution(int[][] maps) {
            init(maps);
            int answer = find(maps,0, 0);

            return answer;
        }

        private void init(int[][] maps) {
            rows = maps.length;
            cols = maps[0].length;
            visited = new boolean[rows][cols];
        }

        private int find(int[][] maps, int x, int y) {
            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{-1, 0, 1, 0};
            int answer = 0;
            Queue<Position> Q = new LinkedList<>();
            Q.offer(new Position(x, y));

            while (!Q.isEmpty()) {
                answer++;
                int size = Q.size();
                for (int i = 0; i < size; i++) {
                    Position p = Q.poll();
                    if (isAnswer(p)) return answer;

                    for (int j = 0; j < 4; j++) {
                        int nx = p.getX() + dx[j];
                        int ny = p.getY() + dy[j];
                        if (isRange(maps, nx, ny) && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                            Q.offer(new Position(nx, ny));
                        }
                    }
                }
            }
            return -1;
        }

        private boolean isRange(int[][] maps, int x, int y) {
            return x >= 0 && y >= 0 && x < cols && y < rows && maps[y][x] == 1;
        }

        private boolean isAnswer(Position p) {
            return p.getY() == rows - 1 && p.getX() == cols - 1;
        }
    }

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

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
