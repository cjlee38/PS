package programmers.undefined;

import java.util.Arrays;

// 프로그래머스 - 구명보트
public class p42885 {
    public static void main(String[] args) {

        // case 1
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        // case 2
//        int[] people = {40, 50, 60, 50};
//        int limit = 100;

        int answer = solution(people, limit);
        System.out.println(answer);
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int j = people.length -1 ;
        for (int i=0; i<= j; i++, answer++) {
            while (j>i && people[i] + people[j--] > limit) {
                answer++;
            }
        }

        return answer;
    }
}
