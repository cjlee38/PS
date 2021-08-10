package codetree.intermediate.low.backtracking.minn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MaxOfXor {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = getArray(n);


        Solution s = new Solution(n, m, array);
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
        private int[] array;

        private int max = 0;

        public Solution(int n, int m, int[] array) {
            this.n = n;
            this.m = m;
            this.array = array;
        }

        public int run() {
            List<Integer> nums = new ArrayList<>();
//            boolean[] visited = new boolean[n];
//            findMaxXor(nums, visited, 0);
            findMaxXor(nums, 0, 0);
            return max;
        }

        private void findMaxXor(List<Integer> nums, int depth, int idx) {
            if (depth == m) {
                max = Math.max(getMaxXor(nums), max);
                return ;
            }
            for (int i = idx; i < n; i++) {
                nums.add(array[i]);
                findMaxXor(nums, depth + 1, i + 1);
                nums.remove(nums.size() - 1);
            }
        }

        private int getMaxXor(List<Integer> nums) {
            System.out.println(nums);
            return nums.stream().mapToInt(Integer::intValue).reduce(0, (x, y) -> x ^ y);
        }


    }
}
