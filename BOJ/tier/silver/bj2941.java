package BOJ.tier.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * uri = https://www.acmicpc.net/problem/2941
 * name = 크로아티아 알파벳
 * tier = silver 5
 * date = 2021-07-2, 금, 18:47
 */

public class bj2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Solution s = new Solution(str);
        bw.write(s.run() + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private String str;

        public Solution(String str) {
            this.str = str;
        }

        public int run() {
            String repl = str.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "X");
            return repl.length();
        }

    } // end of class
}

