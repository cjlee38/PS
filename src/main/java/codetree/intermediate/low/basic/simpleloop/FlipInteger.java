package codetree.intermediate.low.basic.simpleloop;

import java.io.*;

public class FlipInteger {

    static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int r = Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
            bw.write(r + "");

            bw.flush();
            bw.close();
        }
    }
}
