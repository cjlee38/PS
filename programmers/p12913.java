package programmers;

import java.util.Arrays;

public class p12913 {
    static int pos = -1;
    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };

        int result = solution(land);
        System.out.println(result);
    }

    public static int solution(int[][] land) {
        for(int i = 1 ; i < land.length ; i++) {
            for(int j = 0 ; j < land[0].length ; j++) {
                int sum = 0;
                for(int k = 0; k < land[0].length ; k++) {
                    if(k==j)
                        continue;
                    else
                        sum = Math.max(sum, land[i-1][k]);
                }
                land[i][j] += sum;
            }
        }

        Arrays.sort(land[land.length-1]);
        return land[land.length-1][land[0].length-1];
    }

}
