package BOJ.clazz.lv2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10816
 * name = 숫자 카드 2
 */

public class bj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> cards = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(st.nextToken());
            cards.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int c = Integer.parseInt(st.nextToken());
            Integer v = cards.getOrDefault(c, 0);
            bw.write(v + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Solution {


        public int run() {

            return -1;
        }
    }
}
