package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1107
 * name = 리모컨
 */

// review
public class bj1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }


        int ans = Math.abs(n - 100);

        for (int i = 0; i < 1000000; i++) {
            int len = push(broken, i);
            if (len != 0) {
                int count = Math.abs(i - n);
                ans = Math.min(ans, len + count);
            }
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
    }

    private static int push(boolean[] broken, int n) {
        if (n == 0) return broken[0] ? 0 : 1;
        int len = 0;

        for (char c : String.valueOf(n).toCharArray()) {
            if (broken[Character.getNumericValue(c)]) return 0;
            len += 1;
        }

        return len;
    }

}
