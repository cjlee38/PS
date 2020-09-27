package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 프로그래머스 - 같은 숫자는 싫어
public class p12906 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] answer = solution(arr);
        for(int i : answer) {
            System.out.println(i);
        }
    }
    public static int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        for (int i=0; i<arr.length; i++) {
            if (prev != arr[i]) {
                list.add(arr[i]);
                prev = arr[i];
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
