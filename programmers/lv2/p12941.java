package programmers.lv2;

import java.util.Arrays;
import java.util.Collections;

public class p12941 {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        int result = solution(A, B);
        System.out.println(result);
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0, j = B.length-1; i<A.length; i++, j--) {
            answer += A[i] * B[j];
        }

        return answer;
    }

}
