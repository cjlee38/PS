package codetree.intermediate.low.simulation.boom;

import java.io.*;
import java.util.StringTokenizer;

public class CrossShapeBomb {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] map = get2ndArray(n, n);
        int[] bomb = getArray(2);

        Solution s = new Solution(n, map, bomb);
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
        private static final int[] DX = new int[]{0, 1, 0, -1};
        private static final int[] DY = new int[]{-1, 0, 1, -1};
        private int n;
        private int[][] map;
        private int[] bomb;

        public Solution(int n, int[][] map, int[] bomb) {
            this.n = n;
            this.map = map;
            this.bomb = bomb;
        }

        public int run() {
            bomb[0]--;
            bomb[1]--;
            int range = map[bomb[0]][bomb[1]];
            boom(range);
//            drop();
            return -1;
        }

        private void boom(int range) {
            int y = bomb[0];
            int x = bomb[1];
            map[y][x] = 0;
            for (int i = 1; i < range; i++) {

            }
        }
    }
}