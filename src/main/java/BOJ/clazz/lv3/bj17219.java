package BOJ.clazz.lv3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/17219
 * name = 비밀번호 찾기
 * tier = silver 4
 */

public class bj17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();
            map.put(key, value);
        }

        while (k-- > 0) {
            String key = br.readLine();
            bw.write(map.get(key) + "\n");
        }



        bw.flush();
        bw.close();
    }
}
