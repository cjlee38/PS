package programmers.lv3;


import java.util.Arrays;
import java.util.stream.IntStream;

public class p43162 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int[][] computers2 = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };

        int result = solution(n, computers2);
        System.out.println(result);
    }

    public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                recursive(computers, visited, i);
                count++;
            }
        }

        return count;
    }

    public static void recursive(int[][] computers, boolean[] visited, int index) {
        visited[index] = true;
        for(int i = 0; i < computers.length; i++) {
            if (computers[index][i] == 1 && !visited[i]) {
                recursive(computers, visited, i);
            }
        }
    }

}
