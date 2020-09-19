package programmers;

import java.util.Arrays;
import java.util.Comparator;

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
            if (routes[i][1] >= std) {
                continue;
            } else {
                std = routes[i][0];
                answer++;
            }
        }



        return answer;
    }






    public static void print(int[][] costs) {
        for(int i=0; i< costs.length; i++) {
            for (int j=0; j<costs[0].length; j++) {
                System.out.print(costs[i][j]);
            }
            System.out.println();
        }
    }
}
