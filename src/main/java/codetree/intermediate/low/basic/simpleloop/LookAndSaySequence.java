package codetree.intermediate.low.basic.simpleloop;

import java.io.*;

public class LookAndSaySequence {
    static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine()) - 1;
            String s = "1";
            while (n-- > 0)
                s = getNextSequence(s);
            bw.write(s);

            bw.flush();
            bw.close();
        }

        private static String getNextSequence(String s) {
            StringBuilder ret = new StringBuilder();
            char cur = s.charAt(0);
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == cur)
                    cnt++;
                else {
                    ret.append("" + cur + cnt);
                    cnt = 1;
                    cur = c;
                }
            }
            if (cnt != 0)
                ret.append("" + cur + cnt);

            return ret.toString();
        }
    }
}
