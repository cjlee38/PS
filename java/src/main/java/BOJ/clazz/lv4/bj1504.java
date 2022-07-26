package BOJ.clazz.lv4;

import java.io.*;
import java.util.*;

/**
 * uri = https://www.acmicpc.net/problem/1504
 * name = 특정한 최단 경로
 * tier = gold 4
 */

public class bj1504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Map<Integer, List<Vertex>> map = new HashMap<>();
        for (int i = 1; i <= n; i++)
            map.put(i, new ArrayList<>());

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map.get(start).add(new Vertex(end, weight));
            map.get(end).add(new Vertex(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        Solution s = new Solution(n, map, v1, v2);
        int run = s.run();
        bw.write(run + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private static final int INF = 200000000;

        private int n;
        private Map<Integer, List<Vertex>> map;
        private int v1;
        private int v2;

        public Solution(int n, Map<Integer, List<Vertex>> map, int v1, int v2) {
            this.n = n;
            this.map = map;
            this.v1 = v1;
            this.v2 = v2;
        }

        public int run() {
            int path_1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
            int path_2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

            return (path_1 >= INF && path_2 >= INF) ? -1 : Math.min(path_1, path_2);
        }

        private int dijkstra(int start, int end) {
            boolean[] visited = new boolean[n + 1];
            int[] distances = new int[n + 1];
            Arrays.fill(distances, INF);

            PriorityQueue<Vertex> PQ = new PriorityQueue<>();
            PQ.offer(new Vertex(start, 0));
            distances[start] = 0;

            while (!PQ.isEmpty()) {
                Vertex poll = PQ.poll();
                if (visited[poll.getPos()]) continue;
                visited[poll.getPos()] = true;

                for (Vertex vtx : map.get(poll.getPos())) {
                    if (!visited[vtx.getPos()] &&
                            distances[vtx.getPos()] > distances[poll.getPos()] + vtx.getWeight()) {
                        distances[vtx.getPos()] = distances[poll.getPos()] + vtx.getWeight();
                        PQ.add(new Vertex(vtx.getPos(), distances[vtx.getPos()]));
                    }
                }

            }
            return distances[end];
        }

    } // end of class
}

class Vertex implements Comparable<Vertex>{

    private int pos;
    private int weight;

    public Vertex(int pos, int weight) {
        this.pos = pos;
        this.weight = weight;
    }

    public int getPos() {
        return pos;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.weight - o.weight;
    }
}

