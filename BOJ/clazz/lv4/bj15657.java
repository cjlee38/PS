package BOJ.clazz.lv4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/15657
 * name = N과 M (8)
 * tier = silver 3
 */

public class bj15657 {

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
            recursive(0, 0, "");

            return -1;
        }

        private void recursive(int index, int depth, String str) {
            if (depth == m) {
                print(str);
                return ;
            }
            for (int i = index; i < n; i++) {
                recursive(i, depth + 1, str + arr[i] + " ");
            }
        }

        private void print(String str) {
            System.out.println(str.trim());
        }

    } // end of class
}

