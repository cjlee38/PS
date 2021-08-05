package codetree.intermediate.low.simulation.pushpull;

import java.io.*;
import java.util.*;

public class ConveyorBeltTriangle {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr1 = getArray(n);
        int[] arr2 = getArray(n);
        int[] arr3 = getArray(n);

        Solution s = new Solution(n, t, arr1, arr2, arr3);
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
        private int t;
        private int[] arr1;
        private int[] arr2;
        private int[] arr3;

        public Solution(int n, int t, int[] arr1, int[] arr2, int[] arr3) {
            this.n = n;
            this.t = t;
            this.arr1 = arr1;
            this.arr2 = arr2;
            this.arr3 = arr3;
        }

        public String run() {
            Deque<Integer> all = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++)
                all.add(arr1[i]);
            for (int i = 0; i < n; i++)
                all.add(arr2[i]);
            for (int i = 0; i < n; i++)
                all.add(arr3[i]);

            for (int i = 0; i < t % (3 * n); i++)
                all.addFirst(all.pollLast());

            for (int i = 0; i < n; i++)
                sb.append(all.pollFirst() + " ");
            sb.append("\n");
            for (int i = 0; i < n; i++)
                sb.append(all.pollFirst() + " ");
            sb.append("\n");
            for (int i = 0; i < n; i++)
                sb.append(all.pollFirst() + " ");
            return sb.toString();
        }
    }
}
