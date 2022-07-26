package codetree.intermediate.low.dfs.search;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
/*

3 5
1 0 1 1 1
1 0 1 0 1
1 0 0 0 1

 */
public class DetermineEscapablenessWith2Ways {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = get2ndArray(n, m);

        Solution s = new Solution(n, m, map);
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

        private int n;
        private int m;
        private int[][] map;

        private int ans = 0;
        private int[][] dir = new int[][]{
                {0, 1}, // DOWN
                {1, 0} // RIGHT
        };


        public Solution(int n, int m, int[][] map) {
            this.n = n;
            this.m = m;
            this.map = map;
        }

        public int run() {
            boolean[][] visited = new boolean[n][m];
            traverse(visited, 0, 0);
            return ans;
        }

        private void traverse(boolean[][] visited, int x, int y) {
            if (x == m - 1 && y == n - 1) {
                ans = 1;
                return;
            }
            for (int[] dxdy : dir) {
                int nx = x + dxdy[0];
                int ny = y + dxdy[1];
                if (isInRange(nx, ny) && !visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    traverse(visited, nx, ny);
                }
            }

        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < m && y < n;
        }
    }
}