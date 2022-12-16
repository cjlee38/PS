package programmers.lv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p92343 {

    public static void main(String[] args) {
//        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
//        int[][] edges = new int[][]{
//                {0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}
//        };
        int[] info = {0, 1};
        int[][] edges = new int[][]{{0, 1}};
        Solution s = new Solution();
        int result = s.solution(info, edges);
        System.out.println("result = " + result);
    }

    private static class Solution {

        private Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        private int ans = -1;

        public int solution(int[] info, int[][] edges) {
            initialize(edges);
            List<Integer> currents = new ArrayList<>();
            currents.add(0);

            boolean[] visited = new boolean[info.length];
            visited[0] = true;

            run(info, currents, visited, 1, 0);
            return ans;
        }

        private void run(int[] info, List<Integer> currents, boolean[] visited, int sheeps, int wolves) {
            ans = Math.max(sheeps, ans);
            if (sheeps <= wolves) {
                return;
            }

            List<Integer> copyCurrents = new ArrayList<>(currents);
            for (Integer current : currents) {
                List<Integer> nexts = edgeMap.get(current);
                if (nexts == null) {
                    continue;
                }
                for (Integer next : nexts) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    copyCurrents.add(next);

                    if (info[next] == 1) {
                        run(info, copyCurrents, visited, sheeps, wolves + 1);
                    } else {
                        run(info, copyCurrents, visited, sheeps + 1, wolves);
                    }

                    copyCurrents.remove(next);
                    visited[next] = false;
                }
            }
        }

        private void initialize(int[][] edges) {
            for (int[] edge : edges) {
                edgeMap.computeIfAbsent(edge[0], k -> new ArrayList<>());
                edgeMap.get(edge[0]).add(edge[1]);
            }
        }
    }
}
