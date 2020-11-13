package programmers.lv2;

import java.util.Stack;

public class p12909 {

    public static void main(String[] args) {

    }

    public boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') { // 여는 괄호라면, 무조건 Push
                stack.push(c);
            } else { // 닫는 괄호일 때,
                if (!stack.empty()) { // stack이 비어 있지 않고, 최상단이 열린 괄호라면 pop
                    stack.pop();
                } else { // stack이 비어있거나, 최상단이 여는괄호가 아니라면 답은 무조건 false
                    answer = false;
                    break;
                }
            }
        }

        // 모든 array를 다 돌았음에도, stack이 비어 있지 않다면 답은 false (4번에 해당)
        if (!stack.empty()) {
            answer = false;
        }
        return answer;
    }
}

