package BOJ.tag.implementation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2615
 * name = 오목
 * tier = silver 3
 * date = 2021-11-5, 금, 0:22
 */

public class bj2615 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            int size = Solution.SIZE;
            int[][] map = new int[size][size];
            for (int i = 0; i < size; i++) {
                StringTokenizer st = tokenize(br);
                for (int j = 0; j < size; j++) {
                    map[i][j] = sInt(st);
                }
            }

            Solution s = new Solution(map);
            int[] res = s.run();
            bw.write(res[0] + "\n");
            if (res[0] != 0) bw.write(res[1] + " " + res[2]);
            bw.flush();

            // == done == //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static StringTokenizer tokenize(BufferedReader br) throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static int bInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int sInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private static final int SIZE = 19;
        private static final int dir = 4;
        private static final int[] dx = {1, 1, 1, 0};
        private static final int[] dy = {-1, 0, 1, 1};

        private int[][] map;
        private int[][][] dp = new int[SIZE][SIZE][4];

        public Solution(int[][] map) {
            this.map = map;
        }

        public int[] run() {
            int[] ans = new int[3];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] != 0) {
                        if (findWinner(j, i) != 0) {
                            ans[0] = map[i][j];
                            ans[1] = i + 1;
                            ans[2] = j + 1;
                            return ans;
                        }
                    }
                }
            }
            return ans;
        }

        private int findWinner(int x, int y) {
            for (int i = 0; i < dir; i++) {
                if (dp[y][x][i] == 0 && count(x, y, i, map[y][x]) == 5) {
                    return map[y][x];
                }
            }
            return 0;
        }

        private int count(int x, int y, int i, int c) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isInRange(nx, ny) && map[ny][nx] == c)
                return (dp[ny][nx][i] = count(nx, ny, i, c))+ 1;
            return 1;
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < SIZE && y < SIZE;
        }

    } // end of class
}

