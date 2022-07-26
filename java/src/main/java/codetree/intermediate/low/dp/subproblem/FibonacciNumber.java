package codetree.intermediate.low.dp.subproblem;

import java.io.*;
import java.util.StringTokenizer;

public class FibonacciNumber {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Solution s = new Solution(n);
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

        public Solution(int n) {
            this.n = n;
        }

        public int run() {
            int[] fibo = new int[45 + 1];
            fibo[1] = 1;
            fibo[2] = 1;
            for (int i = 3; i <= 45; i++)
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            return fibo[n];
        }
    }
}
