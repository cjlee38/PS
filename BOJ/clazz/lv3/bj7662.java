package BOJ.clazz.lv3;

import java.io.*;
import java.util.*;

/**
 * uri = https://www.acmicpc.net/problem/7662
 * name = 이중 우선순위 큐
 * tier = gold 5
 */

public class bj7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            DoubleQ Q = new DoubleQ();
            int numOfCmds = Integer.parseInt(br.readLine());

            while (numOfCmds-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) Q.insert(val);
                else Q.delete(val);
            }
            bw.write(Q.getAnswer() + "\n");
        }


        bw.flush();
        bw.close();
    }


    static class DoubleQ {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        public void insert(int val) {
            map.compute(val, (k, v) -> v == null ? 1 : v + 1);
        }

        public void delete(int val) {
            if (map.isEmpty()) return;

            int key = val == 1 ? map.lastKey() : map.firstKey();
            if (map.get(key) - 1 == 0) map.remove(key);
            else map.put(key, map.get(key) - 1);
        }

        public String getAnswer() {
            return map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey();
        }
    }
}
