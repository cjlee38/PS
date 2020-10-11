package programmers.lv3;

import java.util.Arrays;

public class p12938 {
    public static void main(String[] args) {

    }

    public static int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        Arrays.fill(answer, s/n);

        int mod = s%n;
        int idx = answer.length-1;
        while(mod != 0) {
            answer[idx] += 1;
            idx--;
            mod--;
        }

        return answer;
    }
}
