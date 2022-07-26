package codetree.intermediate.low.simulation.singlemove;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MoveToLargerAdjacentCell {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = get2ndArray(n, n);

        Solution s = new Solution(n, map, r, c);
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

        private static final int DLEN = 4;
        private static final int[] DX = new int[]{0, 0, -1, 1};
        private static final int[] DY = new int[]{-1, 1, 0, 0};

        private int n;
        private int[][] map;
        private int r;
        private int c;

        public Solution(int n, int[][] map, int r, int c) {
            this.n = n;
            this.map = map;
            this.r = r - 1;
            this.c = c - 1;
        }

        public String run() {
            List<Integer> answer = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            while (true) {
                answer.add(map[r][c]);
                if (!move()) break;
            }
            for (Integer i : answer) {
                sb.append(i + " ");
            }
            return sb.toString();
        }

        private boolean move() {
            int curVal = map[r][c];
            for (int i = 0; i < DLEN; i++) {
                int nx = c + DX[i];
                int ny = r + DY[i];
                if (isInRange(nx, ny) && map[ny][nx] > curVal) {
                    r = ny;
                    c = nx;
                    return true;
                }
            }
            return false;
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < n && y < n;
        }
    }


}
