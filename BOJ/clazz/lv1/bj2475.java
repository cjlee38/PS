package BOJ.clazz.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2475
 * name = 검증수
 */

public class bj2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution s = new solution(arr);
        int result = s.run();
        System.out.println(result);
    }

    static class solution {
        private int[] arr;

        public solution(int[] arr) {
            this.arr = arr;
        }

        public int run() {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i] * arr[i];
            }

            return sum % 10;
        }
    }


}
