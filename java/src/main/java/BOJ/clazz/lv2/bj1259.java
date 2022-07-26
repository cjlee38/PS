package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1436
 * name = 팰린드롬 수
 */

public class bj1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;

        while (!(str = br.readLine()).equals("0")) {
            String answer = new Solution(str).run();
            bw.write(answer + "\n");
            bw.flush();
        }

        bw.close();
    }

    static class Solution {

        private String str;

        public Solution(String str) {
            this.str = str;
        }

        public String run() {
            int right = str.length() / 2;
            int left = str.length() % 2 == 0 ? right - 1 : right;


            // 다르면 right++ 같으면 left-- right++
            while (true) {
                if (right >= str.length() || left < 0) {
                    break;
                } else if (str.charAt(right) == str.charAt(left)) {
                    left--;
                }

                right++;
            }

            if (left == -1) return "yes";
            else return "no";

        }
    }
}
