package codetree.intermediate.low.simulation.pushpull;

import java.io.*;
import java.util.*;

public class ConveyorBelt {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] upArr = getArray(n);
        int[] downArr = getArray(n);

        Solution s = new Solution(n, t, upArr, downArr);
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
        private int[] upArr;
        private int[] downArr;

        public Solution(int n, int t, int[] upArr, int[] downArr) {
            this.n = n;
            this.t = t;
            this.upArr = upArr;
            this.downArr = downArr;
        }

        public String run() {
            Deque<Integer> both = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++)
                both.add(upArr[i]);
            for (int i = 0; i < n; i++)
                both.add(downArr[i]);
            for (int i = 0; i < t % (2 * n); i++)
                both.addFirst(both.pollLast());
            for (int i = 0; i < n; i++)
                sb.append(both.pollFirst() + " ");
            sb.append("\n");
            for (int i = 0; i < n; i++)
                sb.append(both.pollFirst() + " ");
            return sb.toString();
        }
    }
}
