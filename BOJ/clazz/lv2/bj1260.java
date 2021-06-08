package BOJ.clazz.lv2;

import java.io.*;
import java.util.*;

/**
 * uri = https://www.acmicpc.net/problem/
 * name = DFS와 BFS
 * tier = silver 2
 */

public class bj1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        Solution s = new Solution(n, m, v, graph);

        int[] dfs = s.dfs();
        for (int df : dfs) {
            bw.write(df + " ");
        }
        bw.write("\n");
        int[] bfs = s.bfs();
        for (int bf : bfs) {
            bw.write(bf + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n; // num of node
        private int m; // num of egdes
        private int v; // start node
        private int[][] graph; // graph

        public Solution(int n, int m, int v, int[][] graph) {
            this.n = n;
            this.m = m;
            this.v = v;
            this.graph = graph;
        }

        public int[] dfs() {
            boolean[] visited = new boolean[n + 1];
            Stack<Integer> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();

            stack.push(v);
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                if (visited[pop]) continue;

                visited[pop] = true;
                result.add(pop);
                for (int i = n; i > 0; i--) {
                    if (graph[pop][i] != 0 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }

        public int[] bfs() {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();

            queue.offer(v);
            visited[v] = true;
            while (!queue.isEmpty()) {
                int poll = queue.poll();
                result.add(poll);
                for (int i = 1; i <= n; i++) {
                    if (graph[poll][i] != 0 && !visited[i]) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }

    } // end of class
}
