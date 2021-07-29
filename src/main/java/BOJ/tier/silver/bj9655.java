package BOJ.tier.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/9655
 * name = 돌 게임
 * tier = silver 5
 * date = 2021-07-18, 일, 21:22
 */

public class bj9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        bw.write(n % 2 == 0 ? "CY" : "SK");

        bw.flush();
        br.close();
        bw.close();
    }
}

