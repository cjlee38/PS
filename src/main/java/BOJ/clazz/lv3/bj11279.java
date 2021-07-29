package BOJ.clazz.lv3;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11279
 * name = 최대 힙
 * tier = silver 2
 */

public class bj11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> Q = new PriorityQueue<>(Comparator.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (!Q.isEmpty()) bw.write(Q.poll() + "\n");
                else bw.write(0 + "\n");
            }
            else Q.offer(x);
        }

        bw.flush();
        bw.close();
    }

}
