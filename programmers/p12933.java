package programmers;

import java.util.*;

public class p12933 {
    public static void main(String[] args) {
        long n = 118372;
        long result = solution(n);
        System.out.println(result);

    }

    public static long solution(long n) {
        StringBuilder sb = new StringBuilder();
        Integer[] array = String.valueOf(n)
                .chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(x -> Character.getNumericValue(x))
                .toArray(Integer[]::new);
        for(Integer i : array) {
            sb.append(i);
        }

        return Long.parseLong(sb.toString());
    }

}