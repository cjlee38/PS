package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/9461
 * name = 파도반 수열
 * tier = silver 3
 */

public class bj9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        long[] arr = getDP();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[n] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static long[] getDP() {
        long[] arr = new long[100 + 1];
        arr[1] = 1; arr[2] = 1; arr[3] = 1;
        arr[4] = 2; arr[5] = 2;

        for (int i = 6; i <= 100; i++) {
            arr[i] = arr[i-1] + arr[i-5];
        }

        return arr;
    }
}
