package BOJ.clazz.lv2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11650
 * name = 좌표 정렬하기
 */

public class bj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? (o1[1] - o2[1]) : (o1[0] - o2[0]));

        for (int[] rr : arr) {
            bw.write(rr[0] + " " + rr[1] + "\n");
        }

        bw.flush();
        bw.close();
    }

}
