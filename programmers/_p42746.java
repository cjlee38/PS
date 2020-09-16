package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _p42746 {
    public static void main(String[] args) {

        // case 1
//        int[] numbers = {6, 10, 2};
        int[] numbers = {3, 30, 34, 5, 9};

        String answer = solution(numbers);
        System.out.println(answer);

    }

    public static String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(int num : numbers) {
            list.add(String.valueOf(num));
        }
        list.sort(Comparator.reverseOrder());



        String answer = "";
        return answer;
    }
}
