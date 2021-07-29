package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2606
 * name = 바이러스
 * tier = silver 3
 */

public class bj2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] network = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a][b] = true;
            network[b][a] = true;
        }

        Solution s = new Solution(n, network);
        bw.write(s.run() + "");


        bw.flush();
        bw.close();
    }
    static class Solution {

        private int n;
        private boolean[][] network;

        public Solution(int n, boolean[][] network) {
            this.n = n;
            this.network = network;
        }

        public int run() {
            boolean[] visited = new boolean[n + 1];

            return spread(visited, 1)  -1;
        }

        private int spread(boolean[] visited, int row) {

            int count = 1;
            visited[row] = true;
            for (int i = 1; i <= n; i++) {
                if (network[row][i] && !visited[i]) {
//                    visited[i] = true;
                    count += spread(visited, i);
                }
            }
            return count;
        }

    } // end of class
}
