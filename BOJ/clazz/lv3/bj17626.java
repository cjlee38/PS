package BOJ.clazz.lv3;

import java.io.*;

/**
 * uri = https://www.acmicpc.net/problem/17626
 * name = Four Squares
 * tier = silver 5
 */

public class bj17626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Solution s = new Solution(n);
        int res = s.run();
        bw.write(res + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;

        public Solution(int n) {
            this.n = n;
        }

        public int run() {
            int[] arr = new int[n + 1];
            arr[0] = 0;
            arr[1] = 1;

            for (int i = 2; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++)
                    min = Math.min(min, arr[i - j * j]);
                arr[i] = min + 1;
            }
            return arr[n];
        }

    } // end of class
}

