package BOJ.clazz.lv3;

import java.io.*;

/**
 * uri = https://www.acmicpc.net/problem/1676
 * name = 팩토리얼 0의 개수
 */

public class bj1676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int div = 5;
            while (i % div == 0) {
                ans++;
                div *= 5;
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
}
