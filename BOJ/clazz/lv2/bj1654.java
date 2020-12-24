package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1654
 * name = 랜선 자르기
 */

public class bj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lines = new int[k];
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Solution s = new Solution(k, n, lines);
        long result = s.run();

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    static class Solution {
        private int k;
        private int n;
        private int[] lines;

        public Solution(int k, int n, int[] lines) {
            this.k = k;
            this.n = n;
            this.lines = lines;
        }

        public long run() {
            long right = 0;
            for (int i = 0; i < lines.length; i++) {
                right = Math.max(right, lines[i]);
            }

            return binary(1, right);

        }

        private long binary(long left, long right) {
            long ans = 0;

            while(left <= right) {
                long mid = (left + right) / 2;
                if (cut(mid)) {
                    ans = Math.max(ans, mid);
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }

            return ans;

        }

        private boolean cut(long mid) {
            int a = 0;
            for (int i = 0; i < k; i++) {
                a += lines[i] / mid;
            }

            return a >= n;
        }


    }
}
