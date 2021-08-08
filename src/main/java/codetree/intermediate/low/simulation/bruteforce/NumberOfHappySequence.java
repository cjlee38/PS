package codetree.intermediate.low.simulation.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class NumberOfHappySequence {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = get2ndArray(n, n);

        Solution s = new Solution(n, arr, m);

        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    public static int[] getArray(int n) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    public static int[][] get2ndArray(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }

    static class Solution {

        private int n;
        private int[][] arr;
        private int m;

        public Solution(int n, int[][] arr, int m) {
            this.n = n;
            this.arr = arr;
            this.m = m;
        }

        public int run() {

            int cnt = 0;
            // horizontal
            for (int i = 0; i < n; i++) {
                int[] seq = new int[n];
                for (int j = 0; j < n; j++) {
                    seq[j] = arr[i][j];
                }
                if (isHappySequence(seq))
                    cnt++;
            }

            // vertical
            for (int i = 0; i < n; i++) {
                int[] seq = new int[n];
                for (int j = 0; j < n; j++) {
                    seq[j] = arr[j][i];
                }
                if (isHappySequence(seq))
                    cnt++;
            }
            return cnt;
        }

        private boolean isHappySequence(int[] seq) {
            int consecutive = 1;
            int max = 1;
            for (int i = 1; i < n; i++) {
                if (seq[i - 1] == seq[i])
                    consecutive++;
                else
                    consecutive = 1;
                max = Math.max(max, consecutive);
            }
            return max >= m;
        }
    }
}
