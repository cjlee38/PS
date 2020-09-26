package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class p68644 {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        int[] answer = solution(numbers);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int idx = 0;
        for(Integer i : set) {
            answer[idx++] = i;
        }
        Arrays.sort(answer);

        return answer;
    }
}
