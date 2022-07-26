package BOJ.clazz.lv4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1629
 * name = 곱셈
 * tier = silver 1
 */

public class bj1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        bw.write(pow(a, b, c) + "");

        bw.flush();
        bw.close();
    }

    static long pow(long a, long b, long c) {
        if (b == 0) return 1;
        if (b == 1) return a % c;

        long x = pow(a, b / 2, c) % c;
        if (b % 2 == 0) return (x * x) % c;
        else return (((x * x) % c) * a) % c;
    }
}
