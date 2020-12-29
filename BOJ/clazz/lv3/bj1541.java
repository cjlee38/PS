package BOJ.clazz.lv3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1541
 * name = 잃어버린 괄호
 */

public class bj1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Solution s = new Solution(str);

        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    static class Solution {
        private String str;

        public Solution(String str) {
            this.str = str;
        }

        public int run() {
            int sum = Integer.MAX_VALUE;
            String[] sub = str.split("-");

            for (String s : sub) {
                int temp = 0;
                String[] ssub = s.split("\\+");
                for (String ss : ssub) {
                    temp += Integer.parseInt(ss);
                }

                if (sum == Integer.MAX_VALUE) {
                    sum = temp;
                } else {
                    sum -= temp;
                }
            }

            return sum;
        }
    }
}
