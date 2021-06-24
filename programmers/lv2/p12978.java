package programmers.lv2;

import java.util.*;

public class p12978 {
    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        Solution s = new Solution();
        int res = s.solution(N, road, K);
        System.out.println(res);
    }

    static class Solution {
        private static final int INF = 987654321;

        public int solution(int N, int[][] road, int K) {
            int[][] map = initMap(N, road);
            int[] distances = dijkstra(map, N, 1);

            return (int) (Arrays.stream(distances)
                    .filter(x -> x <= K)
                    .count());
        }

        private int[][] initMap(int N, int[][] road) {
            int[][] map = new int[N + 1][N + 1];
            for (int[] r : road) {
                int start = r[0];
                int end = r[1];
                int len = r[2];
                if (map[start][end] != 0 && map[start][end] < len)
                    continue;
                map[start][end] = len;
                map[end][start] = len;
            }

            return map;
        }

        private int[] dijkstra(int[][] map, int N, int start) {
            int[] distances = new int[N + 1];
            boolean[] visited = new boolean[N + 1];
            PriorityQueue<Vertex> PQ = new PriorityQueue<>();

            Arrays.fill(distances, INF);
            distances[start] = 0;
            PQ.offer(new Vertex(start, 0));

            while (!PQ.isEmpty()) {
                Vertex poll = PQ.poll();
                if (visited[poll.pos])
                    continue;
                visited[poll.pos] = true;
                for (int next = 1; next < N + 1; next++) {
                    if (map[poll.pos][next] == 0) continue;
                    if (distances[next] > map[poll.pos][next] + poll.weight) {
                        distances[next] = map[poll.pos][next] + poll.weight;
                        PQ.offer(new Vertex(next, distances[next]));
                    }
                }
            }
            return distances;



        }

        static class Vertex implements Comparable<Vertex> {
            int pos;
            int weight;

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

}
