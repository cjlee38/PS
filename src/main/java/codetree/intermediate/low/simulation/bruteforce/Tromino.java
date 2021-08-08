package codetree.intermediate.low.simulation.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Tromino {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = get2ndArray(n, m);

        Solution s = new Solution(n, m, map);
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
        private static final int SIZE = 3;
        private static final int[][][] TROMINOS = new int[][][]{
                {
                        {1, 0, 0},
                        {1, 1, 0},
                        {0, 0, 0}
                },
                {
                        {1, 1, 0},
                        {1, 0, 0},
                        {0, 0, 0},
                },
                {
                        {1, 1, 0},
                        {0, 1, 0},
                        {0, 0, 0},
                },
                {
                        {0, 1, 0},
                        {1, 1, 0},
                        {0, 0, 0}
                },
                {
                        {1, 1, 1},
                        {0, 0, 0},
                        {0, 0, 0}
                },
                {
                        {1, 0, 0},
                        {1, 0, 0},
                        {1, 0, 0},
                }
        };

        private int n;
        private int m;
        private int[][] map;

        public Solution(int n, int m, int[][] map) {
            this.n = n;
            this.m = m;
            this.map = map;
        }

        public int run() {
            int max = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    max = Math.max(max, getMaxSum(j, i));
                }
            }
            return max;
        }

        private int getMaxSum(int x, int y) {
            int max = -1;
            for (int[][] tromino : TROMINOS) {
                boolean isPossible = true;
                int curSum = 0;
                b:
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (tromino[i][j] == 1) {
                            if (i + y >= n || x + j >= m) {
                                isPossible = false;
                                break b;
                            } else {
                                curSum += map[i + y][x + j];
                            }
                        }
                    }
                }
                if (isPossible) max = Math.max(max, curSum);
            }
            return max;
        }
    }
}
