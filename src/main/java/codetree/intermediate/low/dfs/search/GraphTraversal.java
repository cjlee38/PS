package codetree.intermediate.low.dfs.search;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class GraphTraversal {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.connect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Solution s = new Solution(graph);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    public static int[] getArray(int n) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    public static int[][] get2ndArray(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }

    static class Solution {

        private Graph graph;
        private int ans;

        public Solution(Graph graph) {
            this.graph = graph;
        }

        public int run() {
            boolean[] visited = new boolean[graph.numOfVertex + 1];
            visited[1] = true;
            traverse(visited, 1);
            return ans;
        }

        private void traverse(boolean[] visited, int x) {
            for (Integer next : graph.getNextList(x)) {
                if (!visited[next]) {
                    visited[next] = true;
                    ++ans;
                    traverse(visited, next);
                }
            }
        }
    }

    static class Graph {
        private int numOfVertex;
        private Map<Integer, List<Integer>> graph;

        public Graph(int numOfVertex) {
            this.numOfVertex = numOfVertex;
            graph = new HashMap<>();
            IntStream.rangeClosed(1, numOfVertex)
                    .forEach(x -> graph.put(x, new ArrayList<>()));
        }

        public void connect(int v1, int v2) {
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        public List<Integer> getNextList(int v) {
            return graph.get(v);
        }
    }
}
