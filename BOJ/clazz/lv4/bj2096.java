package BOJ.clazz.lv4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2096
 * name = 내려가기
 * tier = gold 4
 */

public class bj2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        Solution s = new Solution(n, arr);
        int[] result = s.run();
        bw.write(result[0] + " " + result[1]);
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
            int[][] maxdp = new int[n + 1][3];
            int[][] mindp = new int[n + 1][3];

            for (int i = 1; i < maxdp.length; i++) {
                int maxleft = maxdp[i - 1][0];
                int maxmid = maxdp[i - 1][1];
                int maxright = maxdp[i - 1][2];

                int minleft = mindp[i - 1][0];
                int minmid = mindp[i - 1][1];
                int minright = mindp[i - 1][2];
                // left
                maxdp[i][0] = Math.max(maxleft, maxmid) + arr[i][0];
                mindp[i][0] = Math.min(minleft, minmid) + arr[i][0];
                // mid
                maxdp[i][1] = Math.max(maxleft, (Math.max(maxmid, maxright))) + arr[i][1];
                mindp[i][1] = Math.min(minleft, (Math.min(minmid, minright))) + arr[i][1];
                // right
                maxdp[i][2] = Math.max(maxmid, maxright) + arr[i][2];
                mindp[i][2] = Math.min(minmid, minright) + arr[i][2];
            }

            int max = Arrays.stream(maxdp[maxdp.length - 1]).max().getAsInt();
            int min = Arrays.stream(mindp[mindp.length - 1]).min().getAsInt();

            return new int[]{max, min};
        }

    } // end of class
}
