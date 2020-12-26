package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1003
 * name = 피보나치 함수
 */

public class bj1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] f = fibo();

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            bw.write(f[x][0] + " " + f[x][1] + "\n");
        }


        bw.flush();
        bw.close();
    }

    private static int[][] fibo() {
        int[][] arr = new int[41][2];

        arr[0][0] = arr[1][1] = 1;
        arr[0][1] = arr[1][0] = 0;

        for (int i = 2; i <= 40; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
            arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
        }

        return arr;
    }

}
