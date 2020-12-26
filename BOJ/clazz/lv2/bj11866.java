package BOJ.clazz.lv2;

import java.io.*;
import java.util.*;

/**
 * uri = https://www.acmicpc.net/problem/11866
 * name = 요세푸스 문제
 */

public class bj11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Solution s = new Solution(n, k);
        bw.write(s.run() + "");


        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int k;

        public Solution(int n, int k) {
            this.n = n;
            this.k = k;
        }

        public String run() {
            Queue<Integer> Q = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                Q.offer(i);
            }

            int count = 1;
            while (!Q.isEmpty()) {
                if (count++ % k == 0) list.add(Q.poll());
                else Q.offer(Q.poll());
            }

            return "<" + String.join(", ",
                    list.stream().map(String::valueOf).toArray(String[]::new)) + ">";
        }
    }
}
