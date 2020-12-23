package programmers.undefined;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p12910 {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        int[] answer = solution(arr, divisor);
        for(int i : answer) {
            System.out.println(i);
        }

    }

    public static int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        if (list.isEmpty()) {
            list.add(-1);
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
