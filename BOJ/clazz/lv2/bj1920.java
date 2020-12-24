package BOJ.clazz.lv2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1920
 * name = 수 찾기
 */

public class bj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new Solution(n, m, a, b).run();
        for (int r : result) {
            bw.write(r + "\n");
        }

        bw.flush();
        bw.close();
    }

    static class Solution {
        private int n;
        private int m;
        private int[] a;
        private int[] b;

        public Solution(int n, int m, int[] a, int[] b) {
            this.n = n;
            this.m = m;
            this.a = a;
            this.b = b;
        }

        public int[] run() {
            int[] answers = new int[m];
            Arrays.sort(a);

            for(int i = 0; i < m; i++) {
                int cur = b[i];
                if(find(cur, 0, n - 1)) answers[i] = 1;
                else answers[i] = 0;
            }

            return answers;
        }

        public boolean find(int cur, int low, int high) {
            int mid = (low + high) / 2;
            if (a[mid] == cur) return true;
            if (low > high) return false;

            if (a[mid] > cur) return find(cur, low, mid-1);
            else return find(cur, mid+1, high);
        }
    }
}
