package BOJ.clazz.lv2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/4949
 * name = 균형잡힌 세상
 */

public class bj4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
            if (isBalanced(s)) bw.write("yes\n");
            else bw.write("no\n");
        }

        bw.flush();
        bw.close();
    }

    private static boolean isBalanced(String s) {
        s = s.replaceAll("[^\\[\\]()]", "");
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
