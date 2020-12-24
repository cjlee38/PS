package BOJ.clazz.lv2;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * uri = https://www.acmicpc.net/problem/2164
 * name = 카드2
 */

public class bj2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Solution s = new Solution(n);
        int result = s.run();
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;

        public Solution(int n) {
            this.n = n;
        }

        public int run() {
            Queue<Integer> Q = IntStream.range(1, n + 1).boxed().collect(Collectors.toCollection(LinkedList::new));

            while(Q.size() != 1) {
                Q.poll();
                Q.offer(Q.poll());
            }

            return Q.poll();
        }
    }
}
