package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11047
 * name = 동전 0
 * tier = silver 1
 */

public class bj11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Solution s = new Solution(n, k, coins);
        bw.write(s.run() + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int k;
        private int[] coins;

        public Solution(int n, int k, int[] coins) {
            this.n = n;
            this.k = k;
            this.coins = coins;
        }

        public int run() {
            int num = 0;

            for (int i = n - 1; i >= 0; i--) {
                int coin = coins[i];
                num += k / coin;
                k %= coin;
            }

            return num;
        }

    } // end of class
}
