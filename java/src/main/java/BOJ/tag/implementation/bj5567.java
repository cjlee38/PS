package BOJ.tag.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/5567
 * name = 결혼식
 * tier = silver 2
 * date = 2021-11-6, 토, 9:49
 */

public class bj5567 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            int n = bInt(br);
            int m = bInt(br);
            boolean[][] friends = new boolean[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                StringTokenizer st = tokenize(br);
                int a = sInt(st);
                int b = sInt(st);
                friends[a][b] = true;
                friends[b][a] = true;
            }
            Solution s = new Solution(n, m, friends);
            int res = s.run();
            bw.write(res + "");


            // == done == //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static StringTokenizer tokenize(BufferedReader br) throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static int bInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int sInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private int n;
        private int m;
        private boolean[][] relation;

        public Solution(int n, int m, boolean[][] friends) {
            this.n = n;
            this.m = m;
            this.relation = friends;
        }

        public int run() {
            boolean[] friends = new boolean[n + 1];
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                if (relation[1][i]) {
                    friends[i] = relation[1][i];
                    for (int j = 1; j <= n; j++) {
                        if (relation[i][j])
                            friends[j] = relation[i][j];
                    }
                }

            }
            friends[1] = false;
            for (int i = 1; i <= n; i++) {
                if (friends[i]) cnt++;
            }
            return cnt;
        }

    } // end of class
}

