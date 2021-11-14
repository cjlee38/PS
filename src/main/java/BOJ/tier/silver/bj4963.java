package BOJ.tier.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/4963
 * name = 섬의 개수
 * tier = silver 2
 * date = 2021-11-14, 일, 19:11
 */

public class bj4963 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            while (true) {
                st = tokenize(br);
                int w = sInt(st);
                int h = sInt(st);
                if (w == 0 && h == 0) break;

                int[][] map = new int[h][w];
                for (int i = 0; i < h; i++) {
                    st = tokenize(br);
                    for (int j = 0; j < w; j++) {
                        map[i][j] = sInt(st);
                    }
                }
                Solution s = new Solution(w, h, map);
                int res = s.run();
                bw.write(res + "\n");
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

        private static final int dlen = 8;
        private static final int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        private static final int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

        private int w;
        private int h;
        private int[][] map;

        public Solution(int w, int h, int[][] map) {
            this.w = w;
            this.h = h;
            this.map = map;
        }

        public int run() {
            int cnt = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        find(j, i);
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        private void find(int x, int y) {
            map[y][x] = 0;

            for (int i = 0; i < dlen; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isInRange(nx, ny) && map[ny][nx] == 1) {
                    find(nx, ny);
                }
            }
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < w && y < h;
        }

    } // end of class
}

