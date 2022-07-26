package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2798
 * name = 블랙 잭
 */

public class bj2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for(int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Solution s = new Solution(n, m, cards);
        int result = s.run();
        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    static class Solution {
        private int n;
        private int m;
        private int[] cards;

        private int max = -1;

        public Solution(int n, int m, int[] cards) {
            this.n = n;
            this.m = m;
            this.cards = cards;
        }

        public int run() {
            recursive(0, 0, 0);

            return max;
        }

        private void recursive(int idx, int count, int acc) {
            if (count == 3) {
                if (acc <= m && max < acc) {
                    max = acc;
                }
                return;
            }

            for (int i = idx; i < n; i++) {
                recursive(i + 1, count + 1, acc + cards[i]);
            }

        }
    }
}
