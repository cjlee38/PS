package programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class p12954 {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        long[] result = solution(x, n);
        for(long l : result) {
            System.out.println(l);
        }
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for(int i = 1; i < n; i++) {
            answer[i] = answer[i-1] + x;
        }

        return answer;
    }
}
