package BOJ.clazz.lv4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/15652
 * name = N과 M (4)
 * tier = silver 3
 */

public class bj15652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Solution s = new Solution(N, M);
        s.run();
    }

    static class Solution {

        private int N;
        private int M;

        public Solution(int n, int m) {
            N = n;
            M = m;
        }

        public void run() {
            recursive(1, 0, "");
        }

        private void recursive(int num, int depth, String str) {
            if (depth == M) {
                print(str);
                return ;
            }

            for (int i = num ; i <= N; i++)
                recursive(i, depth + 1, str + i + " ");
        }

        private void print(String str) {
            System.out.println(str.trim());
        }



    } // end of class
}

