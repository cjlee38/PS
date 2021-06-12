package BOJ.clazz.lv3;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11286
 * name = 절댓값 힙
 * tier = silver 1
 */

public class bj11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> PQ = new PriorityQueue<>(
                (o1, o2) -> Math.abs(o1) == Math.abs(o2) ?
                        o1 - o2 : Math.abs(o1) - Math.abs(o2)
        );
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int v = Integer.parseInt(br.readLine());
            if (v == 0) bw.write((PQ.isEmpty() ? 0 : PQ.poll()) + "\n");
            else PQ.offer(v);
        }

        bw.flush();
        bw.close();
    }

    static class Solution {

        public int run() {

            return -1;
        }

    } // end of class
}
