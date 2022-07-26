package BOJ.clazz.lv2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/4153
 * name = 직각삼각형
 */

public class bj4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            bw.write(isRight(a, b, c) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static String isRight(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        return (arr[0] * arr[0]) + (arr[1] * arr[1]) == (arr[2] * arr[2]) ? "right" : "wrong";

    }
}
