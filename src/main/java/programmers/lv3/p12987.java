package programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class p12987 {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        int result = solution(A, B);
        System.out.println(result);
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        int aIndex = 0;
        int bIndex = 0;

        Arrays.sort(A); // 1, 3, 5, 7
        Arrays.sort(B); // 2, 2, 6, 8

        for(int i=0; i<A.length; i++) {
            if (A[aIndex] < B[bIndex]) {
                answer++;
                aIndex++;
                bIndex++;
            } else {
                bIndex++;
            }
        }

        return answer;
    }
}
