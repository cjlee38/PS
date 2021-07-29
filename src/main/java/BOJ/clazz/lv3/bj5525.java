package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/5525
 * name = IOIOI
 * tier = silver 2
 */

public class bj5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        Solution s = new Solution(n, m, str);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int m;
        private String str;

        public Solution(int n, int m, String str) {
            this.n = n;
            this.m = m;
            this.str = str;
        }

        public int run() {
            int ans = 0;
            int Ocount = 0;

            for (int i = 0; i < m - 2; i++) {
                if (str.charAt(i) == 'I' &&
                        str.charAt(i + 1) == 'O' &&
                        str.charAt(i + 2) == 'I') {
                    Ocount++;
                    if (Ocount == n) {
                        Ocount--;
                        ans++;
                    }
                    i++;
                } else {
                    Ocount = 0;
                }
            }
            return ans;
        }
    } // end of class
}
