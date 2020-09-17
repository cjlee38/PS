package programmers;

import java.util.Arrays;

public class p42747 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
//        int[] citations = {31, 66};
        int answer = solution(citations);
        System.out.println(answer);

//        0 1 3 5 6 c[i]
//        5 4 3 2 1
//        1 2 3 4 5 i

    }

    public static int solution(int[] citations) {
        int len = citations.length;
        int answer = 0;
        Arrays.sort(citations);
        for (int i=0; i<len; i++) {
            if (citations[i] >= len-i) {
                answer = len-i;
                break;
            }
        }

        return answer;
    }

}
