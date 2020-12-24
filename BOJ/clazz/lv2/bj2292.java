package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2292
 * name = 벌집
 */

public class bj2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Solution s = new Solution(n);
        int result = s.run();
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    static class Solution {
        private static final int MULTIPLIER = 6;
        private int n;

        public Solution(int n) {
            this.n = n;
        }

        public int run() {
            int count = 1, level = 1, sum = 1;
            while (sum < n) {
                sum += level * MULTIPLIER;
                count++;
                level++;
            }

            return count;
        }
    }
}
