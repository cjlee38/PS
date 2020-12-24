package BOJ.clazz.lv2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2231
 * name = 분해합
 */

public class bj2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Solution s = new Solution(n);
        int result = s.run();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;

        public Solution(int n) {
            this.n = n;
        }

        public int run() {
            for (int i = 0; i < n; i++) {
                if (isConstructor(i)) return i;
            }

            return 0;
        }

        private boolean isConstructor(int m) {
            return m + Arrays.stream(String.valueOf(m)
                    .split(""))
                    .mapToInt(Integer::parseInt)
                    .sum() == n;
        }
    }
}
