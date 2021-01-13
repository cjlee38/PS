package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11724
 * name = 연결 요소의 개수
 * tier = silver 2
 */

public class bj11724 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        Solution s = new Solution(n, arr);
        bw.write(s.run() + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int[][] arr;

        public Solution(int n, int[][] arr) {
            this.n = n;
            this.arr = arr;
        }

        public int run() {
            int count = 0;
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(visited, i);
                    count++;
                }
            }
            return count;
        }

        public void dfs(boolean[] visited, int x) {
            if (visited[x]) return;

            visited[x] = true;
            for (int i = 1; i <= n; i++) {
                if (arr[x][i] == 1) dfs(visited, i);
            }
        }

    } // end of class
}
