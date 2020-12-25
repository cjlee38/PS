package BOJ.clazz.lv2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10866
 * name = 덱
 */

public class bj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayDeque<Integer> D = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        int v = -999;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String C = st.nextToken();

            if (C.equals("push_front")) { D.addFirst(Integer.parseInt(st.nextToken())); v = -999; }
            else if (C.equals("push_back")) { D.addLast(Integer.parseInt(st.nextToken())); v = -999; }
            else if (C.equals("pop_front")) if (D.isEmpty()) v = -1; else v = D.pollFirst();
            else if (C.equals("pop_back")) if (D.isEmpty()) v = -1; else v = D.pollLast();
            else if (C.equals("size")) v = D.size();
            else if (C.equals("empty")) v = D.isEmpty() ? 1 : 0;
            else if (C.equals("front")) v = D.isEmpty() ? -1 : D.getFirst();
            else if (C.equals("back")) v = D.isEmpty() ? -1 : D.getLast();

            if (v != -999) bw.write(v + "\n");
        }

        bw.flush();
        bw.close();
    }
}
