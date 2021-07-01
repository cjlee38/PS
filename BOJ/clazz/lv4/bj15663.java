package BOJ.clazz.lv4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/15663
 * name = N과 M (9)
 * tier = silver 3
 */

public class bj15663 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Solution s = new Solution(N, M, arr);
        s.run();
    }

    static class Solution {

        private int n;
        private int m;
        private int[] arr;

        public Solution(int n, int m, int[] arr) {
            this.n = n;
            this.m = m;
            this.arr = arr;
        }

        public int run() {
            Arrays.sort(arr);
            boolean[] visited = new boolean[n];
            recursive(0, "", visited);

            return -1;
        }

        private void recursive(int depth, String str, boolean[] visited) {
            if (depth == m) {
                print(str);
                return ;
            }

            int prev = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && prev != arr[i]) {
                    visited[i] = true;
                    prev = arr[i];
                    recursive(depth + 1, str + arr[i] + " ", visited);
                    visited[i] = false;
                }
            }
        }

        private void print(String str) {
            System.out.println(str.trim());
        }

    } // end of class
}

