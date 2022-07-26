package BOJ.clazz.lv1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11654
 * name = 아스키 코드
 */

public class bj11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = st.nextToken().charAt(0);
        bw.write(c + "");
        bw.flush();
        bw.close();

    }
}
