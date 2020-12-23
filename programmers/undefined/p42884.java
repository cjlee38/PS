package programmers.undefined;

import java.util.Arrays;

// 프로그래머스 - 단속카메라
public class p42884 {
    public static void main(String[] args) {
        int[][] routes = {
                {-20, 15},
                {-14, -5},
                {-18, -13},
                {-5, -3}
        };

        int answer = solution(routes);
        System.out.println(answer);
    }

    public static int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] < o2[1] ? 1 : -1;
            else return o1[0] < o2[0] ? 1 : -1;
        });

        int std = routes[0][0];
        int answer = 1;
        for (int i=1; i<routes.length; i++) {
            System.out.println("std : " + std);
            if (routes[i][1] < std) {
                std = routes[i][0];
                answer++;
            }
        }



        return answer;
    }

}
