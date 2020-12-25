package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2805
 * name = 나무 자르기
 */

public class bj2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] trees = new long[n];
        long max = -1;

        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        Solution s = new Solution(n, m, trees);
        bw.write(s.run(max) + "\n");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int m;
        private long[] trees;

        public Solution(int n, int m, long[] trees) {
            this.n = n;
            this.m = m;
            this.trees = trees;
        }

        public long run(long max) {
            return binary(1, max);
        }

        private long binary(long lo, long hi) {
            long ans = 0;

            while (lo <= hi) {
                long mid = (lo + hi) / 2;
                if (cut(mid)) {
                    ans = Math.max(ans, mid);
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            return ans;
        }

        private boolean cut(long h) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (trees[i] - h > 0) {
                    sum += trees[i] - h;
                }
            }

            return sum >= m;
        }
    }
}
