package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/6064
 * name = 카잉 달력
 * tier = silver 1
 */

public class bj6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Solution s = new Solution(m, n, x, y);
            bw.write(s.run() + "\n");
        }


        bw.flush();
        bw.close();
    }

    static class Solution {

        private int m;
        private int n;
        private int x;
        private int y;

        public Solution(int m, int n, int x, int y) {
            this.m = m;
            this.n = n;
            this.x = x;
            this.y = y;
        }

        public int run() {

            int max = lcm(m, n);

            for (int i = x - 1; i <= max; i += m) {
                if (i % n == y - 1) return i + 1;
            }

            return -1;
        }

        private int lcm(int x, int y) {
            return x * y / gcd(x, y);
        }

        private int gcd(int x, int y) {
            int tmp;
            while(y != 0) {
                tmp = x % y;
                x = y;
                y = tmp;
            }

            return x;
        }

    } // end of class


}
