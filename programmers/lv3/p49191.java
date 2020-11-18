package programmers.lv3;

import java.util.*;

public class p49191 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };

        p49191 p = new p49191();
        int result = p.solution(n, results);
        System.out.println("result = " + result);
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        Map<Integer, List<Integer>> winnerMap = initGames(n, results, true);
        Map<Integer, List<Integer>> loserMap = initGames(n, results, false);

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n];
            recursive(winnerMap, visited, i);
            recursive(loserMap, visited, i);

            int battleCount = countBattle(visited);
            if (battleCount == (n - 1)) answer = answer + 1;
        }

        return answer;
    }

    private void recursive(Map<Integer, List<Integer>> map, boolean[] visited, int enemy) {
        if (map.get(enemy).isEmpty()) return;

        for (Integer val : map.get(enemy)) {
            if (!visited[val - 1]) {
                visited[val - 1] = true;
                recursive(map, visited, val);
            }
        }
    }

    private int countBattle(boolean[] visited) {
        int count = 0;

        for (int i = 0; i < visited.length; i++)
            if (visited[i]) count++;

        return count;
    }

    private Map<Integer, List<Integer>> initGames(int n, int[][] results, boolean isWin) {
        int WINNER = 0;
        int LOSER = 1;
        if (!isWin) {
            WINNER = 1;
            LOSER = 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] result : results) {
            int winner = result[WINNER];
            int loser = result[LOSER];
            map.get(winner).add(loser);
        }

        return map;
    }


}
