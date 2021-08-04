package codetree.intermediate.low.basic;

import java.io.*;
import java.util.StringTokenizer;

public class LeftMostMaxValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = getArray(n, br);
        int index = arr.length;
        while (index != 0) {
            index = getIndexOfLeftMost(arr, index);
            bw.write((index + 1) + " ");
        }



        bw.flush();
        bw.close();
    }

    private static int getIndexOfLeftMost(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static int[] getArray(int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
