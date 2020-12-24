package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2609
 * name = 최대공약수와 최소공배수
 */

public class bj2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Solution s = new Solution(n, m);
        int[] result = s.run();
        bw.write(result[0] + "\n" + result[1]);


        bw.flush();
        bw.close();
    }

    static class Solution {
        private int n;
        private int m;

        public Solution(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int[] run() {
            int gcd = getGcd(n, m);
            int lcm = n * m / gcd;

            return new int[]{gcd, lcm};
        }

        private int getGcd(int n, int m) {
            int temp;
            while (m != 0) {
                temp = n % m;
                n = m;
                m = temp;
            }

            return n;
        }
    }
}
