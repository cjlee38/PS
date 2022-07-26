package BOJ.tier.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10819
 * name = 차이를 최대로
 * tier = silver 2
 * date = 2021-11-20, 토, 15:48
 */

public class bj10819 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            int n = bInt(br);
            StringTokenizer st = tokenize(br);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                 arr[i] = sInt(st);
            }

            Solution s = new Solution(n, arr);
            int res = s.run();
            bw.write(res + "");


            // == done == //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static StringTokenizer tokenize(BufferedReader br) throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static int bInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int sInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private int n;
        private int[] arr;

        private int max = -1;

        public Solution(int n, int[] arr) {
            this.n = n;
            this.arr = arr;
        }

        public int run() {
            boolean[] visited = new boolean[n];
            int[] acc = new int[n];
            recursive(acc, visited, 0);

            return max;
        }

        private void recursive(int[] acc, boolean[] visited, int depth) {
            if (depth == n) {
                maximize(acc);
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    acc[depth] = arr[i];
                    recursive(acc, visited, depth + 1);
                    visited[i] = false;
                }
            }
        }

        private void maximize(int[] acc) {
            max = Math.max(max, calculate(acc));
        }

        private int calculate(int[] acc) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(acc[i] - acc[i + 1]);
            }
            return sum;
        }

    } // end of class
}

