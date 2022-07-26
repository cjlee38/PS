package codetree.intermediate.low.bfs.search;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DetermineEscapablenessWith4Ways {
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

        private static final int dlen = 4;
        private static final int[] dx = new int[]{0, 1, 0, -1};
        private static final int[] dy = new int[]{-1, 0, 1, 0};

        public Solution(int n, int m, int[][] map) {
            this.n = n;
            this.m = m;
            this.map = map;
        }

        public int run() {
            boolean[][] visited = new boolean[n][m];
            traverse(visited,0, 0);
            return visited[n - 1][m - 1] ? 1 : 0;
        }

        private void traverse(boolean[][] visited, int x, int y) {
            Queue<Position> Q = new LinkedList<>();
            visited[y][x] = true;
            Q.offer(new Position(x, y));
            while (!Q.isEmpty()) {
                Position pos = Q.poll();
                for (int i = 0; i < dlen; i++) {
                    int nx = pos.x + dx[i];
                    int ny = pos.y + dy[i];
                    if (isInRange(nx, ny) && !visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        Q.offer(new Position(nx, ny));
                    }
                }
            }
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < m && y < n;
        }
    }

    static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
