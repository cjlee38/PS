package BOJ.clazz.lv3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1620
 * name = 나는야 포켓몬 마스터 이다솜
 */

public class bj1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> rMap = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            map.put(i, br.readLine());
        }

        map.forEach((k, v) -> rMap.put(v, k));

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (Character.isDigit(s.charAt(0))) bw.write(map.get(Integer.parseInt(s)) + "\n");
            else bw.write(rMap.get(s) + "\n");
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
