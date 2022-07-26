package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/9012
 * name = 괄호
 */

public class bj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            boolean ans = new Solution(br.readLine()).run();
            if (ans) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
    }

    static class Solution {

        private String s;

        public Solution(String s) {
            this.s = s;
        }

        public boolean run() {
            int ans = 0;

            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '(') ans++;
                else ans--;
                if (ans < 0) return false;
            }

            return ans == 0;
        }
    }
}
