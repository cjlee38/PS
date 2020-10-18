package programmers.unsolved;

import java.util.*;

public class _p42839 {
    public static void main(String[] args) {
        String numbers = "17";
        int answer = solution(numbers);
        System.out.println(answer);
    }

    public static int solution(String numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length(); i++) {
            Set<String> perm = new HashSet<>();
//            getPermutation(numbers, perm, 0, i);
        }



        int answer = 0;
        return answer;
    }

//    public static isPrime()
//    public static void getPermutation(String numbers, Set<String> perm, int idx, int n, StringBuilder cur) {
//        if (n <= 0) {
//            perm.add
//        }
//        for (int i=idx; i<numbers.length(); i++) {
//            char c = numbers.charAt(i);
//            StringBuilder sb = new StringBuilder(cur);
//            sb.append(c);
//            getPermutation(numbers, perm, i+1, n-1, cur);
//        }
//    }
}
