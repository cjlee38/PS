package programmers.lv2;

import java.util.Stack;

public class p76502 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "[](){}";
        System.out.println(sol.solution(s));
    }

    static class Solution {
        public int solution(String s) {
            int answer = 0;
            for (int i = 0; i < s.length(); i++) {
                s = rotate(s);
                if (isOK(s))
                    answer++;
            }
            return answer;
        }

        private String rotate(String s) {
            StringBuilder sb = new StringBuilder(s);
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            return sb.toString();
        }

        private boolean isOK(String cur) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < cur.length(); i++) {
                char c = cur.charAt(i);
                if (isClose(c)) {
                    if (!st.empty() && isPair(st.peek(), c)) {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    st.push(c);
                }
            }

            return st.isEmpty();
        }

        private boolean isClose(char c) {
            if (c == ']' || c == '}' || c == ')')
                return true;
            return false;
        }

        private boolean isPair(char c1, char c2) {
            if (c1 == '[' && c2 == ']')
                return true;
            if (c1 == '(' && c2 == ')')
                return true;
            if (c1 == '{' && c2 == '}')
                return true;
            return false;
        }
    }
}
