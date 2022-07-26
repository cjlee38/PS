package codetree.intermediate.low.backtracking.simple;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StrongExplosion {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] map = get2ndArray(n, n);

        Solution s = new Solution(n, map);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    public static int[] getArray(int n) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    public static int[][] get2ndArray(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }

    static class Solution {

        private static final int BOMB = 1;
        private int max = -1;

        private int n;
        private int[][] map;

        public Solution(int n, int[][] map) {
            this.n = n;
            this.map = map;
        }

        public int run() {
            List<Bomb> bombs = getBombPosition();
            findMaxArea(bombs, 0);

            return max;
        }

        private void findMaxArea(List<Bomb> bombs, int depth) {
            if (depth == bombs.size()) {
                int area = simulate(bombs);
                max = Math.max(max, area);
                return ;
            }
            Bomb bomb = bombs.get(depth);
            for (int i = 1; i < BombType.values().length; i++) {
                bomb.type = BombType.values()[i];
                findMaxArea(bombs, depth + 1);
                bomb.type = BombType.N;
            }
        }

        private int simulate(List<Bomb> bombs) {
            int cnt = 0;
            int[][] temp = new int[n][n];

            for (Bomb bomb : bombs) {
                int[][] dxdy = bomb.type.dxdy;
                for (int[] xy : dxdy) {
                    int nx = bomb.x + xy[0];
                    int ny = bomb.y + xy[1];
                    if (isInRange(nx, ny) && temp[ny][nx] == 0) {
                        temp[ny][nx] = 1;
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < n && y < n;
        }

        private List<Bomb> getBombPosition() {
            List<Bomb> bombs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == BOMB) bombs.add(new Bomb(j, i, BombType.N));
                }
            }
            return bombs;
        }
    }

    static class Bomb {
        int x;
        int y;
        BombType type;

        public Bomb(int x, int y, BombType type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Bomb{" +
                    "x=" + x +
                    ", y=" + y +
                    ", type=" + type +
                    '}';
        }
    }

    enum BombType {
        N(null),
        I(new int[][]{{0, -2}, {0, -1}, {0, 0}, {0, 1}, {0, 2}}),
        T(new int[][]{{0, -1}, {1, 0}, {0, 0}, {0, 1}, {-1, 0}}),
        X(new int[][]{{-1, -1}, {1, -1}, {0, 0}, {1, 1}, {-1, 1}});

        private int[][] dxdy;

        BombType(int[][] dxdy) {
            this.dxdy = dxdy;
        }
    }
}
