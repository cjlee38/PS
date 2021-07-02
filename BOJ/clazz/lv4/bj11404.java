package BOJ.clazz.lv4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11404
 * name = 플로이드
 * tier = gold 4
 */

public class bj11404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] cities = new int[n + 1][n + 1];
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = pInt(st);
            int end = pInt(st);
            int cost = pInt(st);
            if (cities[start][end] != 0)
                cities[start][end] = Math.min(cities[start][end], cost);
            else
                cities[start][end] = cost;
        }

        Solution s = new Solution(cities, n);
        int[][] res = s.run();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write(res[i][j] + " ");
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        public static final int INF = 987654321;

        private int[][] cities;
        private int n;

        public Solution(int[][] cities, int n) {
            this.cities = cities;
            this.n = n;
        }

        public int[][] run() {
            int[][] res = new int[n + 1][n + 1];
            copy2ndArray(res);
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (res[i][j] > res[i][k] + res[k][j])
                            res[i][j] = res[i][k] + res[k][j];
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (res[i][j] == INF)
                        res[i][j] = 0;
                }
            }
            return res;
        }

        private void copy2ndArray(int[][] t) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == j) continue;
                    t[i][j] = cities[i][j] == 0 ? INF : cities[i][j];
                }
            }

        }

    } // end of class
}

