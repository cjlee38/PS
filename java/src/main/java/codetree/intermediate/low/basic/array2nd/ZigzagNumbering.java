package codetree.intermediate.low.basic.array2nd;

import java.io.*;
import java.util.StringTokenizer;

public class ZigzagNumbering {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int[][] arr = new int[h][w];

        for (int i = 0; i < w; i++) {
            // if even number
            if (i % 2 == 0) {
                 for (int j = 0; j < h; j++) {
                     arr[j][i] = cnt++;
                 }
            } else {
                for (int j = h - 1; j >= 0; j--) {
                    arr[j][i] = cnt++;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
    }

    public static int[] getArray(int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
