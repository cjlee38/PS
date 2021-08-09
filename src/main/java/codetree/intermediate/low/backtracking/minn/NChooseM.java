package codetree.intermediate.low.backtracking.minn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NChooseM {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Solution s = new Solution(n, m);
        s.run();
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

        public Solution(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public void run() {
            List<Integer> nums = new ArrayList<>();
            boolean[] visited = new boolean[n + 1];
            recursive(nums, visited, 0, 1);
        }

        private void recursive(List<Integer> nums, boolean[] visited, int depth, int prev) {
            if (depth == m) {
                print(nums);
                return ;
            }

            for (int i = prev; i <= n; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                nums.add(i);
                recursive(nums, visited, depth + 1, i);
                nums.remove(nums.size() - 1);
                visited[i] = false;
            }
        }

        private void print(List<Integer> nums) {
            StringBuilder sb = new StringBuilder();
            for (Integer num : nums) {
                sb.append(num + " ");
            }
            System.out.println(sb);
        }
    }
}
