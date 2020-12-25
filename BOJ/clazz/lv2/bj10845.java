package BOJ.clazz.lv2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10845
 * name = 큐
 */

public class bj10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayDeque<Integer> Q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if (com.equals("push")) Q.offer(Integer.parseInt(st.nextToken()));
            else if (com.equals("pop")) if (Q.isEmpty()) bw.write("-1\n"); else bw.write(Q.poll() + "\n");
            else if (com.equals("size")) bw.write(Q.size() + "\n");
            else if (com.equals("empty")) if (Q.isEmpty()) bw.write("1\n"); else bw.write("0\n");
            else if (com.equals("front")) if (Q.isEmpty()) bw.write("-1\n"); else bw.write(Q.getFirst() + "\n");
            else if (com.equals("back")) if (Q.isEmpty()) bw.write("-1\n"); else bw.write(Q.getLast() + "\n");
        }

        bw.flush();
        bw.close();
    }

}
