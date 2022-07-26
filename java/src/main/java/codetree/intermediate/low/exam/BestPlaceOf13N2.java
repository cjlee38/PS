package codetree.intermediate.low.exam;

import java.io.*;
import java.util.StringTokenizer;

public class BestPlaceOf13N2 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] board = get2ndArray(n, n);
        Solution s = new Solution(n, board);
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
        private int[][] board;

        private int ans = -1;

        private static final int[] target = {1, 1, 1};
        private static final int MAX_DEPTH = 2;

        public Solution(int n, int[][] board) {
            this.n = n;
            this.board = board;
        }

        public int run() {
            boolean[][] visited = new boolean[n][n];
            traverse(visited,  0);
            return ans;
        }

        private void traverse(boolean[][] visited, int depth) {
            if (depth == MAX_DEPTH) {
                count(visited);
                return ;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && inInsertable(j, i)) {
                        visited[i][j] = visited[i][j + 1] = visited[i][j + 2] = true;
                        traverse(visited, depth + 1);
                        visited[i][j] = visited[i][j + 1] = visited[i][j + 2] = false;
                    }
                }
            }
        }

        private void count(boolean[][] visited) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1 && visited[i][j]) cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }

        private boolean inInsertable(int x, int y) {
            return x <= n - 3;
        }
    }
}
