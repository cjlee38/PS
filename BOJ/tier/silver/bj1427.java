package BOJ.tier.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * uri = https://www.acmicpc.net/problem/1427
 * name = 소트인사이드
 * tier = silver 5
 * date = 2021-07-2, 금, 18:54
 */

public class bj1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String collect = Arrays.stream(br.readLine().split(""))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());
        System.out.println(collect);
        bw.flush();
        br.close();
        bw.close();
    }
}

