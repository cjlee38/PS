package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 - 예산
public class p12982 {
    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;

        int result = solution(d, budget);
        System.out.println(result);
    }

    public static int solution(int[] d, int budget) {
        int sum = 0;
        int count = 0;
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if (sum + d[i] > budget) break;
            sum += d[i];
            count++;
        }

        return count;
    }
}
