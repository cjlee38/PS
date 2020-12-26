package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1074
 * name = Z
 */

public class bj1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = recursive(r, c, (int) Math.pow(2, n));
        bw.write(result + "");

        bw.flush();
        bw.close();
    }

    private static int recursive(int r, int c, int s) {
        int x = 0;
        int y = 0;
        int count = 0;

        while (s > 1) {
            s /= 2;
            if (r < y + s && c < x + s) {

            } else if (r < y + s) {
                count += s * s;
                x += s;
            } else if (c < x + s) {
                count += s * s * 2;
                y += s;
            } else {
                count += s * s * 3;
                x += s;
                y += s;
            }
        }

        return count;
    }


}
