package programmers.undefined;

import java.util.Arrays;
import java.util.Comparator;

public class p42746 {
    public static void main(String[] args) {
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        int[] numbers3 = {0, 0, 0};

        String result1 = solution(numbers1);
        String result2 = solution(numbers2);
        String result3 = solution(numbers3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static String solution(int[] numbers) {
        String[] arr =  Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2+o1).compareTo(o1+o2))
                .toArray(String[]::new);
        return arr[0].equals("0") ? "0" : String.join("", arr);
    }
}
