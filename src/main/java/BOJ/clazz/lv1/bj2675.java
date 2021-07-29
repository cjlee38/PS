package BOJ.clazz.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2675
 * name = 문자열 반복
 */

public class bj2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Solution[] solutions = new Solution[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            solutions[i] = new Solution(count, str);
        }

        for (Solution solution : solutions) {
            solution.run();
        }


    }

    static class Solution {
        private int count;
        private String str;

        public Solution(int count, String str) {
            this.count = count;
            this.str = str;
        }

        public void run() {
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            for (char c : chars) {
                sb.append(String.valueOf(c).repeat(count));
            }

            System.out.println(sb.toString());
        }
    }
}
