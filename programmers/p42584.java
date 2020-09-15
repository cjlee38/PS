package programmers;

import java.util.Stack;

public class p42584 {
    public static void main(String[] args) {

//        int[] prices = {1,2,3,2,3,3}; // 5 4 1 2 1 0
        int[] prices = {1,2,3,2,3,1}; // 5 4 1 2 1 0
        int[] answer = solution(prices);
        for(int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int p = stack.pop();
                answer[p] = i - p;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int p = stack.pop();
            answer[p] = prices.length-1-p;
        }


        return answer;
    }
}
