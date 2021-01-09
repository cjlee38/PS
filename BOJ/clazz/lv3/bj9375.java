package BOJ.clazz.lv3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/9375
 * name = 패션왕 신해빈
 * tier = silver 3
 */

public class bj9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int answer = 1;
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            while(n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();

                map.compute(type, (k,v) -> v == null ? 1 : v + 1);
            }

            for (Integer value : map.values()) {
                answer *= (value + 1);
            }

            bw.write((answer-1) + "\n");
        }

        bw.flush();
        bw.close();
    }

}

