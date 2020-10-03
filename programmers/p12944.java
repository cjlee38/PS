package programmers;

import java.util.Arrays;

// 프로그래머스 - 평균 구하기
public class p12944 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        double answer = solution(arr);
    }
    public static double solution(int[] arr) {
        return (double) Arrays.stream(arr).sum() / arr.length;

    }
}
