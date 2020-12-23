package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1085
 * name = 직사각형에서 탈출
 */

public class bj1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        Solution s = new Solution(x, y, w, h);
        int result = s.run();
        bw.write(result + "");

        bw.flush();
        bw.close();
    }

    static class Solution {
        private int x;
        private int y;
        private int w;
        private int h;

        public Solution(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        public int run() {
            int vertical = Math.min(x, w-x);
            int horizontal = Math.min(y, h-y);

            return Math.min(vertical, horizontal);
        }
    }
}
