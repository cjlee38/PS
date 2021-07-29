package BOJ.clazz.lv1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10809
 * name = 알파벳 찾기
 */

public class bj10809 {
    private final static int ASCII = 97;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        int[] alphas = new int[26];
        Arrays.fill(alphas, -1);

        for (int i = 0; i < str.length(); i++) {
            int pos = str.charAt(i) - ASCII;
            if (alphas[pos] == -1) alphas[pos] = i;
        }

        for (int i = 0; i < alphas.length; i++) {
            bw.write(alphas[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
