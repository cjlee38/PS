package _hidden.wooteco;

public class p5 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int rows = 3;
        int columns = 3;
        int[][] res = s.solution(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Solution {

        private static final int dlen = 2;
        private static final int[] dx = {1, 0};
        private static final int[] dy = {0, 1};

        private int rows;
        private int columns;
        private int[][] map;
        private int[][] directions;

        public int[][] solution(int rows, int columns) {
            init(rows, columns);
            int number = 1;
            int written = 0;
            int dir = 0;
            int x = 0;
            int y = 0;

            while (!isAllWritten(written) && !isLoop(dir, directions[y][x])) {
                if (write(map, x, y, number))
                    ++written;
                directions[y][x] = dir + 1;

                x = get_next_x(x, dir);
                y = get_next_y(y, dir);

                ++number;
                dir = (dir + 1) % dlen;
            }
            return map;
        }

        private int get_next_y(int y, int dir) {
            int ny = y + dy[dir];
            if (ny == rows)
                return 0;
            return ny;
        }

        private int get_next_x(int x, int dir) {
            int nx = x + dx[dir];
            if (nx == columns)
                return 0;
            return nx;
        }

        private boolean isAllWritten(int written) {
            return written == rows * columns;
        }

        private void init(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            this.map = new int[rows][columns];
            this.directions = new int[rows][columns];
        }

        private boolean isLoop(int dir, int i) {
            return dir + 1 == i;
        }

        private boolean write(int[][] map, int x, int y, int number) {
            boolean ret = map[y][x] == 0;
            map[y][x] = number;
            return ret;
        }
    }
}
