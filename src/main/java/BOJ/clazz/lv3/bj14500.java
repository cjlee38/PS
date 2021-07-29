package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/14500
 * name = 테트로미노
 * tier = gold 5
 */

public class bj14500 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution s = new Solution(board, n, m);
        bw.write(s.run() + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private static final int[] dx = new int[]{0, 1, 0, -1};
        private static final int[] dy = new int[]{1, 0, -1, 0};
        private int[][] board;
        private int n;
        private int m;
        private int ans = Integer.MIN_VALUE;

        public Solution(int[][] board, int n, int m) {
            this.board = board;
            this.n = n;
            this.m = m;
        }

        public int run() {
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    recursive(visited, j, i, 0, 0);
                    exceptionT(j, i);
                }
            }


            return ans;
        }

        private void exceptionT(int x, int y) {
            int wing = 4;
            int min = Integer.MAX_VALUE;
            int sum = board[y][x];
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                //날개가 2개이상 없다면 ㅗ 모양이 아니다. 그러므로 함수를 종료한다.
                if (wing <= 2)
                    return;
                //날개가 맵 바깥에 있다면 날개가 아니다.
                if (!isValid(nextX, nextY)) {
                    wing--;
                    continue;
                }
                min = Math.min(min, board[nextY][nextX]);
                sum += board[nextY][nextX];
            }
            //날개가 4개일때 가장 작은 날개를 없애야 ㅗ,ㅏ,ㅓ,ㅜ 모양이 나온다.
            if (wing == 4) {
                sum = sum - min;
            }
            ans = Math.max(ans, sum);
        }

        private void recursive(boolean[][] visited, int x, int y, int depth, int sum) {
            if (depth == 4) {
                ans = Math.max(ans, sum);
                return ;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (isValid(nextX, nextY) && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    recursive(visited, nextX, nextY, depth + 1, sum + board[nextY][nextX]);
                    visited[nextY][nextX] = false;
                }
            }
        }

        private boolean isValid(int x, int y) {
            return x >= 0 && y >= 0 && x < m && y < n;
        }

    } // end of class

}
