package codetree.intermediate.low.basic;

import java.io.*;
import java.util.StringTokenizer;

public class MinOfNNum {

    static class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int min = Integer.MAX_VALUE;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (min > x) {
                    min = x;
                    cnt = 1;
                } else if (min == x) {
                    cnt++;
                }
            }

            bw.write(min + " " + cnt);

            bw.flush();
            bw.close();
        }
    }
}
