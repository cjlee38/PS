package codetree.intermediate.low.exam;

import java.io.*;
import java.util.StringTokenizer;

public class Near500 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] arr = getArray(10);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v < 500) max = Math.max(max, v);
            if (v > 500) min = Math.min(min, v);
        }
        bw.write(max + " " + min);
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

        public int run() {
            return -1;
        }
    }
}
