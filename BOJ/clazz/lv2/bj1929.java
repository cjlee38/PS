package BOJ.clazz.lv2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1929
 * name = 소수 구하기
 */

public class bj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (sieve[i]) {
                for (int j = i + i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }

        }

        for (int i = m; i <= n; i++) {
            if (sieve[i]) bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }

}
