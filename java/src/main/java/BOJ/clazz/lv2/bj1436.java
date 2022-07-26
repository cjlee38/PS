package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1436
 * name = 영화감독 숌
 */

public class bj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Solution s = new Solution(n);
        String result = s.run();
        bw.write(result);

        bw.flush();
        bw.close();
    }

    static class Solution {
        private int n;

        public Solution(int n) {
            this.n = n;
        }

        public String run() {
            int num = 665;
            while (n > 0) {
                num++;
                if (String.valueOf(num).contains("666")) {
                    n--;
                }
            }

            return String.valueOf(num);
        }
    }

}
