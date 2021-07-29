package programmers.lv3;

import java.util.*;

/**
 * uri = https://programmers.co.kr/learn/courses/30/lessons/49189
 * name = 가장 먼 노드
 */
public class p49189 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        Solution s = new Solution();
        int res = s.solution(n, edge);
        System.out.println(res);
    }

    static class Solution {
        public int solution(int n, int[][] edge) {
            int max = 0;
            int[] distances = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            Map<Integer, Set<Integer>> edgeMap = createEdgeMap(edge);
            Queue<Integer> Q = new LinkedList<>();

            visited[1] = true;
            Q.offer(1);

            while (!Q.isEmpty()) {
                Integer p = Q.poll();
                for (Integer i : edgeMap.get(p)) {
                    if (!visited[i]) {
                        distances[i] = distances[p] + 1;
                        max = Math.max(max, distances[i]);
                        visited[i] = true;
                        Q.offer(i);
                    }
                }
            }
            int finalMax = max;
            return (int) Arrays.stream(distances).filter(x -> x == finalMax).count();
        }

        private Map<Integer, Set<Integer>> createEdgeMap(int[][] edge) {
            Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
            for (int[] e : edge) {
                int start = e[0];
                int end = e[1];

                if (!edgeMap.containsKey(start)) edgeMap.put(start, new HashSet<>());
                if (!edgeMap.containsKey(end)) edgeMap.put(end, new HashSet<>());

                edgeMap.get(start).add(end);
                edgeMap.get(end).add(start);
            }
            return edgeMap;
        }
    }


}
