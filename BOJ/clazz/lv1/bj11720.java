package BOJ.clazz.lv1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11720
 * name = 숫자의 합
 */

public class bj11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String number = br.readLine();

        int sum = 0;

        String[] split = number.split("");
        for (String s : split) {
            sum += Integer.parseInt(s);
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();


    }
}
