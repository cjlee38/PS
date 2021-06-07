package programmers.lv3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p67259 {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };
//        int[][] board = new int[][] {
//                {0, 0, 0},
//                {0, 0, 0},
//                {0, 0, 0}
//        };
        Solution s = new Solution();
        int res = s.solution(board);
        System.out.println(res);
    }
    static class Solution {
        static final int STRAIGHT_PRICE = 100;
        static final int CORNER_PRICE = 600;

        public int solution(int[][] board) {
            return Math.min(bfs(board, 1), bfs(board, 2));
        }

        private int bfs(int[][] board, int direction) {
            int[][] priceBoard = new int[board.length][board.length];
            Queue<Road> Q = new LinkedList<>();
            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{-1, 0, 1, 0};

            Q.offer(new Road(0, 0, 0, direction));
            while (!Q.isEmpty()) {
                Road road = Q.poll();

                if (road.getX() == board.length - 1 && road.getY() == board.length - 1) {
                    priceBoard[road.getY()][road.getX()] =
                            Math.min(priceBoard[road.getY()][road.getX()], road.getPrice());
                }
                for (int i = 0; i < 4; i++) {
                    int nx = road.getX() + dx[i];
                    int ny = road.getY() + dy[i];
                    int nprice = road.getDir() == i ? STRAIGHT_PRICE + road.getPrice() : CORNER_PRICE + road.getPrice();
                    if (isPossible(board, nx, ny)
                            && isCheaper(priceBoard, nx, ny, nprice)) {
                        priceBoard[ny][nx] = nprice;
                        Q.offer(new Road(nx, ny, nprice, i));
                    }
                }
            }

            return priceBoard[board.length - 1][board.length - 1];
        }

        private boolean isPossible(int[][] board, int x, int y) {
            if (x < 0 || y < 0 || x >= board.length || y >= board.length)
                return false;
            return board[y][x] != 1;
        }

        private boolean isCheaper(int[][] priceBoard, int x, int y, int nprice) {
            if (priceBoard[y][x] == 0)
                return true;
            return nprice < priceBoard[y][x];

        }
    }

    static class Road {
        private int x;
        private int y;
        private int price;
        private int dir;

        public Road(int x, int y, int price, int dir) {
            this.x = x;
            this.y = y;
            this.price = price;
            this.dir = dir;
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

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getDir() {
            return dir;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }
    }
}
