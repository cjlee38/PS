package codetree.intermediate.low.simulation.multiplemove;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MoveToMaxAdjacentCellSimultaneously {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = get2ndArray(n, n);
        int[][] count = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            count[r - 1][c - 1] = 1;
        }

        Solution s = new Solution(n, map, count, t);
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
        public static final int DLEN = 4;
        public static final int[] DX = new int[]{0, 0, -1, 1};
        public static final int[] DY = new int[]{-1, 1, 0, 0};

        private int n;
        private int[][] map;
        private int[][] count;
        private int t;

        public Solution(int n, int[][] map, int[][] count, int t) {
            this.n = n;
            this.map = map;
            this.count = count;
            this.t = t;
        }

        public int run() {
            while (t-- > 0) {
                moveBalls();
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (count[i][j] != 0)
                        sum++;
                }
            }
            return sum;
        }

        private void moveBalls() {
            int[][] temp = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (count[i][j] != 0) {
                        int[] next = getNextPos(i, j);
                        temp[next[0]][next[1]]++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    count[i][j] = temp[i][j] == 1 ? 1 : 0;
                }
            }
        }

        private int[] getNextPos(int y, int x) {
            int maxVal = -1;
            int maxX = -1, maxY = -1;

            for (int i = 0; i < DLEN; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];
                if (isInRange(nx, ny) && maxVal < map[ny][nx]) {
                    maxX = nx;
                    maxY = ny;
                    maxVal = map[ny][nx];
                }
            }
            return new int[]{maxY, maxX};
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < n && y < n;
        }

    }
}
