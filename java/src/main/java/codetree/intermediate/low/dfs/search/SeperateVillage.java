package codetree.intermediate.low.dfs.search;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SeperateVillage {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] map = get2ndArray(n, n);

        Solution s = new Solution(n, map);
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
        private int temp;

        private static final int dlen = 4;
        private static final int[] dx = new int[]{0, 1, 0, -1};
        private static final int[] dy = new int[]{-1, 0, 1, 0};

        public Solution(int n, int[][] map) {
            this.n = n;
            this.map = map;
        }

        public String run() {
            boolean[][] visited = new boolean[n][n];
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        visited[i][j] = true;
                        temp = 1;
                        traverse(visited, j, i);
                        ans.add(temp);
                    }
                }
            }
            return ans.stream()
                    .sorted()
                    .map(String::valueOf)
                    .reduce(ans.size() + "", (x, y) -> x + "\n" + y);
        }

        private void traverse(boolean[][] visited, int x, int y) {
            for (int i = 0; i < dlen; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isInRange(nx, ny) && !visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    temp++;
                    traverse(visited, nx, ny);
                }
            }
        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < n && y < n;
        }
    }
}
