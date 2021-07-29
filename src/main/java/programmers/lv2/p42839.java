package programmers.lv2;

import com.sun.source.tree.UsesTree;

import java.util.*;

public class p42839 {
    private Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "011";

        p42839 p = new p42839();
        int result = p.solution(numbers);
        System.out.println("result = " + result);
        System.out.println("p = " + p.set);
    }

    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        int count = 0;
        for (int i = 1; i <= numbers.length(); i++) {
            boolean[] visited = new boolean[numbers.length()];
            count += recursive(arr, visited, i, 0, new StringBuilder());
        }

        return count;
    }

    private int recursive(char[] arr, boolean[] visited, int r, int cur, StringBuilder sb) {
        if (cur == r) {
            Integer num = convertToInt(sb);
            if (!set.contains(num) && isPrime(num)) {
                set.add(num);
                return 1;
            }
            return 0;
        }

        int count = 0;
        String str = sb.toString();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            count += recursive(arr, visited, r, cur+1, new StringBuilder(new StringBuilder(str).append(arr[i])));
            visited[i] = false;
        }

        return count;
    }

    private boolean isPrime(Integer num) {
        if (num == 0 || num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    private Integer convertToInt(StringBuilder sb) {
        return Integer.parseInt(sb.toString());
    }

}
