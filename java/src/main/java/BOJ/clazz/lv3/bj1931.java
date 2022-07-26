package BOJ.clazz.lv3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1931
 * name = 회의실배정
 */

public class bj1931 {

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
        bw.write(s.run() + "");


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

        public int run() {
            Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

            int prev = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (prev <= arr[i][0]) {
                    prev = arr[i][1];
                    count++;
                }
            }

            return count;

        }
    } // end of class
}
