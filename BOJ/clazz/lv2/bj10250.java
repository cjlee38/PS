package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10250
 * name = ACM 호텔
 */

public class bj10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            bw.write(new Solution(h, w, n).run() + "\n");
        }


        bw.flush();
        bw.close();
    }

    static class Solution {

        private int h;
        private int w;
        private int n;

        public Solution(int h, int w, int n) {
            this.h = h;
            this.w = w;
            this.n = n;
        }

        public String run() {
            n--;

            String left = ((n % h) + 1) + "";
            String right = ((n / h) + 1) + "";


            if (Integer.parseInt(right) < 10) right = "0" + right;

            return left + right;
        }
    }
}
