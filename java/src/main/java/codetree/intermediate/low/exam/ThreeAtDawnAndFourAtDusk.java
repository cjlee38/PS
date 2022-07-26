package codetree.intermediate.low.exam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ThreeAtDawnAndFourAtDusk {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] works = get2ndArray(n, n);

        Solution s = new Solution(n, works);
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
        private int[][] works;

        private int ans = Integer.MAX_VALUE;

        public Solution(int n, int[][] works) {
            this.n = n;
            this.works = works;
        }

        public int run() {
            boolean[] visited = new boolean[n];
            getCombination(visited, 0, 0);
            return ans;
        }

        private void getCombination(boolean[] visited, int depth, int idx) {
            if (depth == n / 2) {
                count(visited);
                return ;
            }

            for (int i = idx; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    getCombination(visited, depth + 1, i + 1);
                    visited[i] = false;
                }
            }
        }

        private void count(boolean[] visited) {
            List<Integer> dawnWorks = new ArrayList<>();
            List<Integer> duskWorks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) dawnWorks.add(i);
                else duskWorks.add(i);
            }
            ans = Math.min(ans, Math.abs(getHardness(dawnWorks) - getHardness(duskWorks)));
        }

        private int getHardness(List<Integer> worklist) {
            int hardness = 0;
            for (int i = 0; i < worklist.size(); i++) {
                for (Integer integer : worklist) {
                    hardness += works[worklist.get(i)][integer];
                }
            }
            return hardness;
        }
    }
}
