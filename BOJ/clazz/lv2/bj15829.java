package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * uri = https://www.acmicpc.net/problem/15829
 * name = Hashing
 */

public class bj15829 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String org = br.readLine();

        Solution s = new Solution(n, org);
        bw.write(s.run() + "");

        bw.flush();
        bw.close();
    }

    static class Solution {
        public static final int ASCII = 97;
        public static final int R = 31;
        public static final int M = 1234567891;
        private int n;
        private String org;

        public Solution(int n, String org) {
            this.n = n;
            this.org = org;
        }

        public long run() {
            long sum = 0;
            long mul = 1;
            for (int i = 0; i < n; i++) {
                int x = org.charAt(i) - ASCII + 1;
                sum += (x * mul);
                mul = (mul * R) % M;
            }

            return sum % M;
        }
    }
}
