package programmers.lv1;

import java.util.Arrays;

// K 번째 수
public class p42748 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3},
        };

        int[] answer = solution(array, commands);
        for(int a : answer) {
            System.out.println(a);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i< commands.length; i++) {
            int[] c= commands[i];
            int[] arr = Arrays.copyOfRange(array, c[0]-1, c[1]);
            Arrays.sort(arr);
            answer[i] = arr[c[2]-1];
        }


        return answer;
    }
}
