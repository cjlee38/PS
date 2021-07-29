package BOJ.clazz.lv4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/9935
 * name = 문자열 폭발
 * tier = gold 4
 */

public class bj9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bomb = br.readLine();

        Solution s = new Solution(str, bomb);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private String str;
        private String bomb;

        public Solution(String str, String bomb) {
            this.str = str;
            this.bomb = bomb;
        }

        public String run() {
            Stack<Character> st = new Stack<>();

            for (char c : str.toCharArray()) {
                st.push(c);
                if (st.size() >= bomb.length()) {
                    boolean flag = true;
                    for (int i = 0; i < bomb.length(); i++) {
                        if (st.get(st.size() - bomb.length() + i) != bomb.charAt(i)) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        for (int i = 0; i < bomb.length(); i++) {
                            st.pop();
                        }
                    }
                }
            }


            StringBuilder sb = new StringBuilder();
            for (char c : st) sb.append(c);
            return sb.length() == 0 ? "FRULA" : sb.toString();
        }

    } // end of class
}
