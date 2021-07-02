package BOJ.tier.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1316
 * name = 그룹 단어 체커
 * tier = silver 5
 * date = 2021-07-2, 금, 18:33
 */

public class bj1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n-- > 0) {
            String str = br.readLine();
            Solution s = new Solution(str);
            if (s.run()) count++;
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }


    static class Solution {
        private static final int NUM_OF_ALPHAS = 26;
        private String str;

        public Solution(String str) {
            this.str = str;
        }

        public boolean run() {
            boolean[] alphas = new boolean[NUM_OF_ALPHAS];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int index = c - 'a';
                if (alphas[index])
                    return false;
                alphas[index] = true;
                while (i < str.length() && str.charAt(i) == c)
                    i++;
                i--;
            }
            return true;
        }

    } // end of class
}

