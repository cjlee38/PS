package codetree.intermediate.low.simulation.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class BestPlaceOf33 {
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
        private final static int SIZE = 3;
        private int n;
        private int[][] map;

        public Solution(int n, int[][] map) {
            this.n = n;
            this.map = map;
        }

        public int run() {
            int max = 0;
            for (int i = 0; i <= n - SIZE; i++) {
                for (int j = 0; j <= n - SIZE; j++) {
                    max = Math.max(max, getSumOfArea(j, i));
                }
            }
            return max;
        }

        private int getSumOfArea(int x, int y) {
            int sum = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    sum += map[i + y][j + x];
                }
            }
            return sum;
        }
    }
}