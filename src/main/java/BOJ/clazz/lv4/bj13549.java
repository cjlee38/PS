package BOJ.clazz.lv4;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/13549
 * name = 숨바꼭질 3
 * tier = gold 5
 */

public class bj13549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = pInt(st);
        int k = pInt(st);

        Solution s = new Solution(n, k);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        public static final int MAX_SIZE = 100_000;
        private int n;
        private int k;

        public Solution(int n, int k) {
            this.n = n;
            this.k = k;
        }

        public int run() {
            boolean[] visited = new boolean[MAX_SIZE + 1];
            PriorityQueue<Subin> Q = new PriorityQueue<>();

            visited[n] = true;
            Q.offer(new Subin(n, 0));

            while (!Q.isEmpty()) {
                Subin poll = Q.poll();
                visited[poll.pos] = true;
                if (poll.pos == k)
                    return poll.elapsed;
                goNext(Q, visited, new Subin(poll.pos + 1, poll.elapsed + 1));
                goNext(Q, visited, new Subin(poll.pos - 1, poll.elapsed + 1));
                goNext(Q, visited, new Subin(poll.pos * 2, poll.elapsed));
            }
            return -1;
        }

        private void goNext(Queue<Subin> Q, boolean[] visited, Subin next) {
            if (isInRange(next.pos) && !visited[next.pos]) {
                Q.offer(next);
            }
        }

        private boolean isInRange(int pos) {
            return pos >= 0 && pos <= MAX_SIZE;
        }

    } // end of class

    static class Subin implements Comparable<Subin> {
        private int pos;
        private int elapsed;

        public Subin(int pos, int elapsed) {
            this.pos = pos;
            this.elapsed = elapsed;
        }

        @Override
        public int compareTo(Subin o) {
            return this.elapsed - o.elapsed;
        }
    }
}

