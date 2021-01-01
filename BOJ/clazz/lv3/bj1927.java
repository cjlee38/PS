package BOJ.clazz.lv3;

import java.io.*;
import java.util.PriorityQueue;

/**
 * uri = https://www.acmicpc.net/problem/1927
 * name = 최소 힙
 */

public class bj1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> PQ = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!PQ.isEmpty()) bw.write(PQ.poll() + "\n");
                else bw.write("0\n");
            } else {
                PQ.offer(num);
            }
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
