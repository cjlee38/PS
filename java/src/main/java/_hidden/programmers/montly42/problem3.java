package _hidden.programmers.montly42;

import java.util.*;

public class problem3 {

    public static void main(String[] args) {
        int[] a = new int[]{-5, 0, 2, 1, 2};
        int[][] edges = new int[][] {
                {0, 1},
                {3, 4},
                {2, 3},
                {0, 3}
        };
        Solution s = new Solution();
        long res = s.solution(a,edges);
        System.out.println(res);
    }

    static class Solution {
        long count = 0;

        public long solution(int[] a, int[][] edges) {
            if (!isPossible(a))
                return -1L;

            boolean[] visited = new boolean[a.length];
            int pos = findMaxPosition(a);
            Map<Integer, List<Integer>> map = buildEdges(a, edges);

            recursive(a, map, visited, pos, -1);
            return count;
        }

        private Map<Integer, List<Integer>> buildEdges(int[]a, int[][] edges) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < a.length; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int[] edge : edges) {
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }

            return map;
        }

        private int findMaxPosition(int[] a) {
            int pos = 0;
            int val = -1;
            for (int i = 0; i < a.length; i++) {
                if (val < Math.abs(a[i])) {
                    val = Math.abs(a[i]);
                    pos = i;
                }
            }
            return pos;
        }

        private void recursive(int[] a, Map<Integer, List<Integer>> edges, boolean[] visited, int cur, int prev) {
            if (visited[cur])
                return;

            visited[cur] = true;
            for (Integer child : edges.get(cur)) {
                if (!visited[child])
                    recursive(a, edges, visited, child, cur);
            }
            balance(a, cur, prev);
        }

        private void balance(int[] a, int cur, int prev) {
            if (prev == -1)
                return;

            count += Math.abs(a[cur]);
            a[prev] += a[cur];
            a[cur] = 0;
        }

        public boolean isPossible(int[] a) {
            return Arrays.stream(a).sum() == 0;
        }
    }

}