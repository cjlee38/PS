package BOJ.clazz.lv3;

import java.io.*;
import java.util.*;

/**
 * uri = https://www.acmicpc.net/problem/1764
 * name = 듣보잡
 */

public class bj1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                list.add(str);
            }
        }

        Collections.sort(list);
        bw.write(list.size() + "\n");
        for (String s : list) {
            bw.write(s + "\n");
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
