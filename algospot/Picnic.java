package algospot;

/*

3
2 1
0 1
4 6
0 1 1 2 2 3 3 0 0 2 1 3
6 10
0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 소풍
public class Picnic {
    public static void main(String[] args) throws IOException {
        List<Picnic_solution> problems = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < c; ++i) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            boolean[][] areFriends = new boolean[n][n];

            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                areFriends[a][b] = true;
                areFriends[b][a] = true;
            }


            problems.add(new Picnic_solution(n, m, areFriends));

        }


        for (Picnic_solution problem : problems) {
            int answer = problem.run();
            System.out.println(answer);
        }
    }

    static class Picnic_solution {
        private int n;
        private int m;
        private boolean[][] areFriends;

        public Picnic_solution(int n, int m, boolean[][] areFriends) {
            this.n = n;
            this.m = m;
            this.areFriends = areFriends;
        }

        public int run() {

            boolean[] paired = new boolean[n];

            int ret = countPairings(paired);

            return ret;
        }

        private int countPairings( boolean[] paired) {
            int target = isAllPaired(paired);
            if (target == -1) return 1;

            int ret = 0;
            for (int i = target + 1; i < n; i++) {
                if (!paired[i] && areFriends[target][i]) {
                    paired[target] = paired[i] = true;
                    ret += countPairings(paired);
                    paired[target] = paired[i] = false;
                }
            }

            return ret;
        }

        public int isAllPaired(boolean[] paired) {
            int target = -1;
            for (int i = 0; i < n; ++i) {
                if (!paired[i]) {
                    target = i;
                    break;
                }

            }

            return target;
        }
    }
}

