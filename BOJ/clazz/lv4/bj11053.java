package BOJ.clazz.lv4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11053
 * name = 가장 긴 증가하는 부분수열
 * tier = silver 2
 */

public class bj11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Solution s = new Solution(n, arr);
        bw.write(s.run() + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int[] arr;

        public Solution(int n, int[] arr) {
            this.n = n;
            this.arr = arr;
        }

        public int run() {
            int[] dp = new int[n + 1];
            int ret = 0;

            for (int i = 1; i < n + 1; i++) {
                int val = arr[i];

                if (val > dp[ret]) {
                    ret++;
                    dp[ret] = val;
                } else {
                    int loc = binarySearch(dp, 0, ret, val);
                    dp[loc] = val;
                }
            }

            return ret;
        }

        public int binarySearch(int[] dp, int lo, int hi, int val) {
            if (lo == hi) return lo;

            int mid = (lo + hi) / 2;
            if (dp[mid] == val) return mid;
            else if (dp[mid] < val) return binarySearch(dp, mid + 1, hi, val);
            else return binarySearch(dp, lo, mid, val);
        }

    } // end of class
}
