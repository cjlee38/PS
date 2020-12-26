package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11050
 * name = 이항 계수 1
 */

public class bj11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Solution s = new Solution(n, k);
        bw.write(s.run() + "");


        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int k;

        public Solution(int n, int k) {
            this.n = n;
            this.k = k;
        }

        public int run() {
            return recursive(0, 0);
        }

        private int recursive(int index, int count) {
            if (index == n) return count == k ? 1 : 0;

            return recursive(index + 1, count + 1) + recursive(index + 1, count);
        }


    }
}
