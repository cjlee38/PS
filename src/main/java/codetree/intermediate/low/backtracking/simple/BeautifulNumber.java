package codetree.intermediate.low.backtracking.simple;

import java.io.*;
import java.util.StringTokenizer;

public class BeautifulNumber {
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
        private int count = 0;

        public Solution(int n) {
            this.n = n;
        }

        public int run() {
            int[] arr = new int[n];
            recursive(arr, 0);
            return count;
        }

        public void recursive(int[] arr, int depth) {
            if (depth == n) {
                if (isBeautifulNumber(arr)) ++count;
                return ;
            }
            for (int i = 1; i <= 4; i++) {
                arr[depth] = i;
                recursive(arr, depth + 1);
                arr[depth] = 0;
            }
        }

        private boolean isBeautifulNumber(int[] arr) {
            for (int i = 0; i < n; i += arr[i]) {
                if (i + arr[i] - 1 >= n) return false;
                for (int j = i; j < i + arr[i]; j++) {
                    if (arr[i] != arr[j]) return false;
                }
            }
            return true;
        }
    }
}
