package codetree.intermediate.low.basic;

import java.io.*;
import java.util.StringTokenizer;

public class PerfectNumber {
    static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = start; i <= end; i++) {
                if (isPerfectNumber(i)) cnt++;
            }
            bw.write(cnt + "");
            bw.flush();
            bw.close();
        }

        private static boolean isPerfectNumber(int num) {
            int sum = 0;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0)
                    sum += i;
            }
            return sum == num;
        }
    }
}
