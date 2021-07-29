package BOJ.tier.silver;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


/**
 * uri = https://www.acmicpc.net/problem/17413
 * name = 단어 뒤집기 2
 * tier = silver 3
 * date = 2021-07-2, 금, 17:55
 */

public class bj17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Solution s = new Solution(str);
        bw.write(s.run() + "");
        bw.flush();
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

        public String run() {
            boolean isTag = false;
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();

            for (char c : str.toCharArray()) {
                if (c == '<') {
                    isTag = true;
                    flush(sb, stack);
                    sb.append(c);
                } else if (c == '>') {
                    sb.append(c);
                    isTag = false;
                } else {
                    if (c == ' ') {
                        flush(sb, stack);
                        sb.append(c);
                    }
                    else if (!isTag) stack.push(c);
                    else sb.append(c);
                }
            }
            flush(sb, stack);
            return sb.toString();
        }

        private void flush(StringBuilder sb, Stack<Character> stack) {
            while (!stack.isEmpty())
                sb.append(stack.pop());
        }

    } // end of class
}
