package BOJ.clazz.lv4;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1238
 * name = 파티
 * tier = gold 3
 */

public class bj1238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] roads = new int[n + 1][n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            roads[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        Solution s = new Solution(roads, n, x);
        bw.write(s.run() + "\n");

        bw.flush();
        bw.close();
    }

    static class Solution {

        public static final int INF = 987654321;

        private int roads[][];
        private int n;
        private int x;

        public Solution(int[][] roads, int n, int x) {
            this.roads = roads;
            this.n = n;
            this.x = x;
        }

        public int run() {
            int ans = -INF;
            int[] startDistances = dijkstra(x);
            reverseRoads();
            int[] endDistances = dijkstra(x);

            for (int i = 1; i <= n; i++)
                ans = Math.max(ans, startDistances[i] + endDistances[i]);
            return ans;
        }

        private int[] dijkstra(int start) {
            int[] distances = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            PriorityQueue<Vertex> PQ = new PriorityQueue<>();

            Arrays.fill(distances, INF);
            distances[start] = 0;
            PQ.offer(new Vertex(start, 0));

            while (!PQ.isEmpty()) {
                Vertex poll = PQ.poll();
                if (visited[poll.pos])
                    continue;
                visited[poll.pos] = true;
                for (int i = 1; i <= n; i++) {
                    if (roads[poll.pos][i] == 0) continue; // if roads not connected
                    if (distances[i] > roads[poll.pos][i] + poll.weight) {
                        distances[i] = roads[poll.pos][i] + poll.weight;
                        PQ.offer(new Vertex(i, distances[i]));
                    }
                }
            }
            return distances;
        }

        private void reverseRoads() {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    int temp = roads[i][j]; // 1 2
                    roads[i][j] = roads[j][i];
                    roads[j][i] = temp;
                }
            }
        }

    } // end of class

    static class Vertex implements Comparable<Vertex> {
        private int pos;
        private int weight;

        public Vertex(int pos, int weight) {
            this.pos = pos;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex v) {
            return this.weight - v.weight;
        }
    }
}

