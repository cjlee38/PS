package programmers.undefined;

import java.util.*;


// 프로그래머스 - 큰 수 만들기
public class p42883 {
    public static void main(String[] args) {

        // case 1
//        String number = "1924";
//        int k = 2;

        // case 2
        String number = "4177252841";
        int k = 4;

        String answer = solution(number, k);
        System.out.println(answer);
    }

    public static String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek()<c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }


    /* failed
    public static String solution(String number, int k) {
        List<String> numbers = new ArrayList<>();
        recursive(number, numbers, new StringBuilder(), 0, number.length()-k);
        Collections.sort(numbers, Comparator.reverseOrder());

        return numbers.get(0);
    }

    public static void recursive(String number, List<String> numbers, StringBuilder sb, int idx, int len) {
        if (sb.length() == len) {
            numbers.add(sb.toString());
            return;
        } else {
            for (int i=idx; i<number.length(); i++) {
                StringBuilder csb = new StringBuilder(sb).append(number.charAt(i));
                recursive(number, numbers, csb, i+1, len);
            }
        }
    }

     */



}