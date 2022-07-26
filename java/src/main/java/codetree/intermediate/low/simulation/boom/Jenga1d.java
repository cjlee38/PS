package codetree.intermediate.low.simulation.boom;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Jenga1d {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> jenga = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            jenga.add(Integer.parseInt(br.readLine()));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s2 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());
        for (int i = s1; i <= e1; i++) {
            jenga.remove(s1 - 1);
        }
        for (int i = s2; i <= e2; i++) {
            jenga.remove(s2 - 1);
        }
        bw.write(jenga.size() + "\n");
        for (Integer i : jenga) {
            bw.write(i + "\n");
        }

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

        public int run() {
            return -1;
        }
    }
}
