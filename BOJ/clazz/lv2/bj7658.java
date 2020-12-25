package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/7658
 * name = 덩치
 */

public class bj7658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Solution s = new Solution(n, arr);
        int[] ans = s.run();
        for (int i = 0; i < ans.length; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Solution {
        private int n;
        private int[][] arr;

        public Solution(int n, int[][] arr) {
            this.n = n;
            this.arr = arr;
        }

        public int[] run() {
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int count = 1;
                for (int j = 0; j < n; j++) {
                    if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) count++;
                }
                ans[i] = count;
            }
            return ans;
        }
    }
}
