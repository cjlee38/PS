package BOJ.tier.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1915
 * name = 가장 큰 정사각
 * tier = gold 5
 * date = 2021-07-17, 토, 22:0
 */

public class bj1915 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = pInt(st);
        int m = pInt(st);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        Solution s = new Solution(arr, n, m);
        bw.write(s.run() + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private int[][] arr;
        private int n;
        private int m;

        public Solution(int[][] arr, int n, int m) {
            this.arr = arr;
            this.n = n;
            this.m = m;
        }

        public int run() {
            int max = -1;
            int[][] dp = new int[n][m];

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (arr[i - 1][j - 1] > 0 &&
                            arr[i - 1][j] > 0 &&
                            arr[i][j - 1] > 0) {
                        arr[i][j] = trimin(arr[i - 1][j - 1], arr[i - 1][j], arr[i][j - 1]) + 1;
                        max = Math.max(max, arr[i][j]);
                    }
                }
            }

//            for (int i = 0 ; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            return max * max;
        }

        private int trimin(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }

    } // end of class
}
