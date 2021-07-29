package BOJ.tag.implementation;

import java.io.*;
import java.util.*;

/**
 * uri = https://www.acmicpc.net/problem/16234
 * name = 인구 이동
 * tier = gold 5
 * date = 2021-07-26, 월, 10:11
 */

public class bj16234 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = pInt(st);
        int l = pInt(st);
        int r = pInt(st);
        int[][] countries = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                countries[i][j] = pInt(st);
            }
        }

        Solution s = new Solution(n, countries, l, r);
        bw.write(s.run() + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {
        private static final int DLEN = 4;
        private static final int[] dx = new int[]{0, 1, 0, -1};
        private static final int[] dy = new int[]{-1, 0, 1, 0};

        private int n;
        private int[][] map;
        private int l;
        private int r;

        public Solution(int n, int[][] map, int l, int r) {
            this.n = n;
            this.map = map;
            this.l = l;
            this.r = r;
        }

        public int run() {
            int day = 0;

            while (true) {
                List<Union> unions = getUnions();
                if (unions.isEmpty())
                    break;
                else
                    migratePopulations(unions);
                day++;
            }

            return day;
        }

        private void print() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        private void migratePopulations(List<Union> unions) {
            for (Union union : unions) {
                migrate(union);
            }
        }

        private void migrate(Union union) {
            int avg = (int) union.countries.stream()
                    .mapToInt(x -> x.population)
                    .average()
                    .getAsDouble();
            union.countries.stream()
                    .forEach(x -> x.setPopulation(map, avg));
        }

        private List<Union> getUnions() {
            boolean[][] visited = new boolean[n][n];
            List<Union> unions = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        Union union = uniteCountries(visited, i, j);
                        if (union.countries.size() > 1)
                            unions.add(union);
                    }
                }
            }
            return unions;
        }

        private Union uniteCountries(boolean[][] visited, int y, int x) {
            Union union = new Union();
            Queue<Country> Q = new LinkedList<>();

            Country country = new Country(x, y, map[y][x]);
            union.unite(country);
            Q.add(country);
            visited[y][x] = true;

            while (!Q.isEmpty()) {
                Country poll = Q.poll();

                for (int i = 0; i < DLEN; i++) {
                    int nx = poll.x + dx[i];
                    int ny = poll.y + dy[i];
                    if (isInRange(nx, ny) && !visited[ny][nx] && canUnite(poll.x, poll.y, nx, ny)) {
                        visited[ny][nx] = true;
                        country = new Country(nx, ny, map[ny][nx]);
                        union.unite(country);
                        Q.offer(country);
                    }
                }
            }
            return union;
        }

        private boolean canUnite(int x, int y, int nx, int ny) {
            int diffOfPopulations = Math.abs(map[y][x] - map[ny][nx]);
            return l <= diffOfPopulations && diffOfPopulations <= r;
        }

        private boolean isInRange(int nx, int ny) {
            return nx >= 0 && ny >= 0 && nx < n && ny < n;
        }
    } // end of class

    static class Union {
        private Set<Country> countries;

        public Union() {
            this.countries = new HashSet<>();
        }

        public void unite(Country country) {
            this.countries.add(country);
        }
    }

    static class Country {
        private int x;
        private int y;
        private int population;

        public Country(int x, int y, int population) {
            this.x = x;
            this.y = y;
            this.population = population;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Country country = (Country) o;
            return x == country.x && y == country.y;
        }

        public void setPopulation(int[][] map, int avg) {
            map[y][x] = avg;
        }
    }
}

