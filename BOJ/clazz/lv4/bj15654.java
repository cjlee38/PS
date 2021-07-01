package BOJ.clazz.lv4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/15654
 * name = N과 M (5)
 * tier = silver 3
 */

public class bj15654 {

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

        private int N;
        private int M;
        private int[] arr;

        public Solution(int n, int m, int[] arr) {
            N = n;
            M = m;
            this.arr = arr;
        }

        public void run() {
            boolean[] visited = new boolean[N];
            Arrays.sort(arr);
            recursive(0, "", visited);
        }

        private void recursive(int depth, String str, boolean[] visited) {
            if (depth == M) {
                print(str);
                return;
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
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

