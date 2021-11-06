package BOJ.tag.implementation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/16926
 * name = 배열 돌리기 1
 * tier = silver 2
 * date = 2021-11-6, 토, 10:29
 */

public class bj16926 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            st = tokenize(br);
            int n = sInt(st);
            int m = sInt(st);
            int rotation = sInt(st);
            int[][] array = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = tokenize(br);
                for (int j = 0; j < m; j++) {
                    array[i][j] = sInt(st);
                }
            }

            Solution s = new Solution(n, m, rotation, array);
            int[][] res = s.run();
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    bw.write(res[i][j] + " ");
                }
                bw.write("\n");
            }


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

        private static final int[] dx = {1, 0, -1, 0};
        private static final int[] dy = {0, 1, 0, -1};

        private int n;
        private int m;
        private int r;
        private int[][] array;

        public Solution(int n, int m, int r, int[][] array) {
            this.n = n;
            this.m = m;
            this.r = r;
            this.array = array;
        }

        public int[][] run() {
            int group = Math.min(n, m) / 2;
            // r = sanitize();
            while (r-- > 0) {
                rotateAll(group);
            }
            return array;
        }

        private void rotateAll(int group) {
            while (group-- > 0) {
                rotateOne(group);
            }
        }

        private void rotateOne(int cur) {
            int x = cur;
            int y = cur;

            int dir = 0;
            while (dir < 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (isInRange(nx, ny, cur)) {
                    swap(x, y, nx, ny);
                    x = nx;
                    y = ny;
                } else {
                    dir++;
                }
            }
            swap(cur, cur, cur, cur + 1);
        }

        private void print() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }

        private void swap(int x, int y, int nx, int ny) {
            int temp = array[y][x];
            array[y][x] = array[ny][nx];
            array[ny][nx] = temp;
        }

        private boolean isInRange(int x, int y, int v) {
            return x >= v && y >= v && x < m - v && y < n - v;
        }

        private int sanitize() {
            int mod = (n + m - 2) * 2;
            return r % mod;
        }

    } // end of class
}

