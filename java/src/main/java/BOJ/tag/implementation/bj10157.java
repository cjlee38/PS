package BOJ.tag.implementation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10157
 * name = 자리배정
 * tier = silver 4
 * date = 2021-10-27, 수, 23:36
 */

public class bj10157 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            StringTokenizer st = tokenize(br);
            int C = sInt(st);
            int R = sInt(st);
            int num = bInt(br);

            Solution s = new Solution(C, R, num);
            String res = s.run();
            System.out.println(res);


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

        private static final int[] dx = {0, 1, 0, -1};
        private static final int[] dy = {-1, 0, 1, 0};


        private int C;
        private int R;
        private int num;

        public Solution(int c, int r, int num) {
            C = c;
            R = r;
            this.num = num;
        }

        public String run() {
            if (R * C < num)
                return "0";
            int[][] map = new int[R][C];
            int x = 0;
            int y = R - 1;

            int direction = 0;
            int cur = 1;
            while (cur < num) {
                map[y][x] = cur;
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                if (isOutOfRange(nx, ny) || isExist(map, nx, ny)) {
                    direction = (direction + 1) % 4;
                    nx = x + dx[direction];
                    ny = y + dy[direction];
                }
                x = nx;
                y = ny;
                cur++;
            }
            return (x + 1) + " " + (R - y);
        }

        private boolean isExist(int[][] map, int x, int y) {
            return map[y][x] != 0;
        }

        private boolean isOutOfRange(int x, int y) {
            return !(x >= 0 && y >= 0 && x < C && y < R);
        }

    } // end of class
}

