package BOJ.clazz.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * uri = https://www.acmicpc.net/problem/1157
 * name = 단어 공부
 */

public class bj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        bj1157 b = new bj1157();
        String result = b.run(str);
        System.out.println(result);
    }

    public String run(String str) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(str.split(""))
                .forEach(x -> map.compute(x, (k, v) -> v == null ? 1 : v + 1));

        String c = "";
        int max = -1;
        boolean flag = false;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();

            if (val > max) {
                flag = false;
                max = val;
                c = entry.getKey();
            } else if (val == max) {
                flag = true;
            }
        }

        if (flag) return "?";
        else return c;
    }
}
