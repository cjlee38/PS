package BOJ.clazz.lv2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1978
 * name = 소수 찾기
 */

public class bj1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] sieve = new boolean[1000 + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i <= Math.sqrt(1000); i++) {
            if (sieve[i]) {
                for (int j = i + i; j <= 1000; j += i) {
                    sieve[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sieve[arr[i]]) count++;
        }

        bw.write(count + "\n");


        bw.flush();
        bw.close();
    }

    static class Solution {


        public int run() {

            return -1;
        }
    }
}
