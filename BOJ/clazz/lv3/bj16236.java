package BOJ.clazz.lv3;


import java.io.*;
import java.util.*;

/**
 * uri = https://www.acmicpc.net/problem/16236
 * name = 아기 상어
 * tier = gold 4
 */

public class bj16236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Solution s = new Solution(n, map);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    static class Solution {

        static class Position {

            @Override
            public String toString() {
                return "Position{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }

            public static final int[] dx = new int[]{0, -1, 1, 0};
            public static final int[] dy = new int[]{-1, 0, 0, 1};

            private int x;
            private int y;

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }
        }

        static class Shark {

            public static final int PASSIBLE = 0;
            public static final int EATABLE = 1;
            public static final int FAIL = -1;

            private int size ;
            private int eaten;
            private Position pos;

            public Shark(int size, int eaten) {
                this.size = size;
                this.eaten = eaten;
            }

            public void setPosition(Position pos) {
                this.pos = pos;
            }

            public int getSize() {
                return size;
            }

            public Position getPos() {
                return pos;
            }

            public int measureFish(int fish) {
                return Integer.compare(this.size, fish);
            }

            private int eat(Fish fish, int[][] map) {
                eaten++;
                if (eaten == size) {
                    size++;
                    eaten = 0;
                }

                this.pos = fish.pos;
                map[this.pos.getY()][this.pos.getX()] = 0;
                return fish.dist;
            }
        }

        static class Fish implements Comparable<Fish> {

            private Position pos;
            private int dist;

            public Fish(Position pos, int dist) {
                this.pos = pos;
                this.dist = dist;
            }


            @Override
            public int compareTo(Fish o) {
                if (this.dist == o.dist) {
                    if (this.pos.getY() == o.pos.getY()) return this.pos.getX() - o.pos.getX();
                    else return this.pos.getY() - o.pos.getY();
                }

                return this.dist - o.dist;

            }
        }
        private int n;
        private int[][] map;

        public Solution(int n, int[][] map) {
            this.n = n;
            this.map = map;
        }

        public int run() {
            Shark baby = new Shark(2, 0);
            int time = 0;
            int elapsed;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 9) {
                        map[i][j] = 0;
                        baby.setPosition(new Position(j, i));
                    }
                }
            }


            while ((elapsed = findFish(baby)) != -1) {
                time += elapsed;
            }

            return time;
        }

        private int findFish(Shark baby) {
            boolean[][] visited = new boolean[n][n];
            Queue<Position> Q = new LinkedList<>();
            List<Fish> fishes = new ArrayList<>();
            int distance = 0;

            Position pos = baby.getPos();
            visited[pos.getY()][pos.getX()] = true;
            Q.add(pos);

            while(!Q.isEmpty()) {
                int size = Q.size();
                distance++;
                for (int i = 0; i < size; i++) {
                    Position cur = Q.poll();
                    int curX = cur.getX();
                    int curY = cur.getY();
                    for (int j = 0; j < 4; j++) {
                        int nextX = curX + Position.dx[j];
                        int nextY = curY + Position.dy[j];
                        if (isInRange(nextX, nextY) && !visited[nextY][nextX]) {

                            int cmp = map[nextY][nextX] == 0 ? Shark.PASSIBLE : baby.measureFish(map[nextY][nextX]);
                            if (cmp == Shark.EATABLE) { // found fish which can be eaten by shark
                                visited[nextY][nextX] = true;
                                Q.offer(new Position(nextX, nextY));
                                fishes.add(new Fish(new Position(nextX, nextY), distance));
                            }
                            else if (cmp == Shark.PASSIBLE) { // same size
                                visited[nextY][nextX] = true;
                                Q.offer(new Position(nextX, nextY));
                            }
                        }
                    }
                }
            }

            // if fish is null, distance is -1, else distance
            Collections.sort(fishes);
            if (fishes.size() == 0) return -1;
            else return baby.eat(fishes.get(0), map);


        }

        private boolean isInRange(int x, int y) {
            return x >= 0 && y >= 0 && x < n && y < n;
        }


    }

}
