package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11403
 * name = 경로 찾기
 * tier = silver 1
 */

public class bj11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Solution s = new Solution(n, graph);
        int[][] result = s.run();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int[][] graph;

        public Solution(int n, int[][] graph) {
            this.n = n;
            this.graph = graph;
        }

        public int[][] run() {
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (graph[i][k] == 1&& graph[k][j] == 1)
                            graph[i][j] = 1;
                    }
                }
            }
            return graph;
        }
    } // end of class
}
