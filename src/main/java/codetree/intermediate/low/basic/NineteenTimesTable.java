package codetree.intermediate.low.basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class NineteenTimesTable {

    static class Main {

        private static final int FINAL_NUMBER = 19;

        public static void main(String[] args) throws IOException {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 1; i <= FINAL_NUMBER; i++) {
                for (int j = 1; j <= FINAL_NUMBER; j++) {
                    bw.write(i + " * " + j + " = " + i * j);
                    bw.write(j % 2 != 0 && j != FINAL_NUMBER ? " / " : "\n");
                }
            }

            bw.flush();
            bw.close();
        }
    }
}
