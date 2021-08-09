package codetree.intermediate.low.backtracking.simple;

import java.io.*;
import java.util.*;

public class KPermutationsOfKWithRepetition {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Solution s = new Solution(k, n);
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

        private final int k;
        private final int n;

        public Solution(int k, int n) {
            this.k = k;
            this.n = n;
        }

        public void run() {
            Deque<Integer> nums = new ArrayDeque<>();
            recursive(nums, 0);
            return ;
        }

        private void recursive(Deque<Integer> nums, int depth) {
            if (depth == n) {
                print(nums);
                return ;
            }
            for (int i = 1; i <= k; i++) {
                nums.addLast(i);
                recursive(nums, depth + 1);
                nums.pollLast();
            }
        }

        private void print(Deque<Integer> nums) {
            StringBuilder sb = new StringBuilder();
            for (Integer num : nums) {
                sb.append(num + " ");
            }
            System.out.println(sb);
        }
    }
}
