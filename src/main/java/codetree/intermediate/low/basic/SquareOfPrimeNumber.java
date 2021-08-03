package codetree.intermediate.low.basic;

import java.io.*;
import java.util.StringTokenizer;

public class SquareOfPrimeNumber {

    static class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = start; i <= end; i++) {
                int numOfDivisor = getDivisor(i);
                if (numOfDivisor == 3)
                    cnt++;
            }
            bw.write(cnt + "");
            bw.flush();
            bw.close();
        }

        private static int getDivisor(int v) {
            int cnt = 0;
            for (int i = 1; i <= v; i++) {
                if (v % i == 0)
                    ++cnt;
            }
            return cnt;
        }
    }
}
