package BOJ.tag.implementation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/12871
 * name = 무한 문자열
 * tier = silver 5
 * date = 2021-10-26, 화, 22:55
 */

public class bj12871 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            String s = br.readLine();
            String t = br.readLine();

            Solution solution = new Solution(s, t);
            int res = solution.run();
            bw.write(res + "");
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

        private String s;
        private String t;

        public Solution(String s, String t) {
            this.s = s;
            this.t = t;
        }

        public int run() {
            if (s.equals(t))
                return 1;

            int lcm = calculateLCM(s.length(), t.length());
            String repeatedS = repeat(s, lcm);
            String repeatedT = repeat(t, lcm);
            if (repeatedS.equals(repeatedT))
                return 1;
            return 0;
        }

        private String repeat(String str, int len) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() != len)
                sb.append(str);
            return sb.toString();
        }

        private int calculateLCM(int a, int b) {
            return a * b / calculateGCD(a, b);
        }

        private int calculateGCD(int a, int b) {
            while (b > 0) {
                int temp = a;
                a = b;
                b = temp % b;
            }
            return a;
        }


    } // end of class
}

