package programmers.undefined;

import java.util.Arrays;
import java.util.stream.IntStream;

public class p12939 {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        String result = solution(s);
        System.out.println(result);
    }

    public static String solution(String s) {
        int[] arr = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        return arr[0] + " " + arr[arr.length-1];
    }
}
