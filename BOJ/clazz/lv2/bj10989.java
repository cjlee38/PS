package BOJ.clazz.lv2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10989
 * name = 수 정렬하기 3
 */

public class bj10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int r : arr) {
            sb.append(r + "\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    static class Solution {


        public int run() {

            return -1;
        }
    }
}
