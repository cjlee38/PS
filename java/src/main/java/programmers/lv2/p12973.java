package programmers.lv2;

import java.util.Stack;

public class p12973 {
    public static void main(String[] args) {
        String s = "cdcd";
        int result = solution(s);
        System.out.println(result);
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }

        return stack.isEmpty()? 1 : 0;
    }

}
