package codetree.intermediate.low.basic.strings;

import java.io.*;
import java.util.StringTokenizer;

public class ShiftReverseString {

    static class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            while (n-- > 0) {
                int command = Integer.parseInt(br.readLine());
                if (command == 1) {
                    sb.append(sb.charAt(0));
                    sb.deleteCharAt(0);
                }
                else if (command == 2) {
                    sb.insert(0, sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);
                }
                else if (command == 3)
                    sb.reverse();
                System.out.println(sb.toString());
            }

            bw.flush();
            bw.close();
        }
    }
}
