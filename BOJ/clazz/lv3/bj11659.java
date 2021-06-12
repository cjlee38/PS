package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11659
 * name = 구간 합 구하기 4
 * tier = silver 3
 */

public class bj11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] summations = new int[n + 1];
        summations[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            summations[i] = summations[i - 1] + Integer.parseInt(st.nextToken());
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(summations[end] - summations[start - 1] + "\n");
        }


        bw.flush();
        bw.close();
    }
}
