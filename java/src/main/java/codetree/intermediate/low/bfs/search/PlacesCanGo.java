package codetree.intermediate.low.bfs.search;

import java.io.*;
import java.util.*;

public class PlacesCanGo {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = get2ndArray(n, n);
        List<Position> starts = new ArrayList<>();
        while (k-- > 0) {
            int[] pos = getArray(2);
            starts.add(new Position(pos[1] - 1, pos[0] - 1));
        }
        Solution s = new Solution(n, map, starts);
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
        private int[][] map;
        private List<Position> starts;

        private static final int dlen = 4;
        private static final int[] dx = new int[]{0, 1, 0, -1};
        private static final int[] dy = new int[]{-1, 0, 1, 0};

        public Solution(int n, int[][] map, List<Position> starts) {
            this.n = n;
            this.map = map;
            this.starts = starts;
        }

        public int run() {
            boolean[][] visited = new boolean[n][n];
            for (Position start : starts) {
                traverse(visited, start);
            }
            return count(visited);
        }

        private int count(boolean[][] visited) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) cnt++;
                }
            }
            return cnt;
        }


        private void traverse(boolean[][] visited, Position start) {
            Queue<Position> Q = new LinkedList<>();
            Q.offer(start);
            if (visited[start.y][start.x]) return;
            visited[start.y][start.x] = true;

            while (!Q.isEmpty()) {
                Position pos = Q.poll();
                for (int i = 0; i < dlen; i++) {
                    int nx = pos.x + dx[i];
                    int ny = pos.y + dy[i];
                    if (isInRange(nx, ny) && !visited[ny][nx] && map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        Q.offer(new Position(nx, ny));
                    }

                }
            }
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < n && y < n;
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
