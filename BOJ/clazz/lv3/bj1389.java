package BOJ.clazz.lv3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1389
 * name = 케빈 베이컨의 6단계 법칙
 * tier = silver 1
 */

public class bj1389 {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] friends = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j)
                    friends[i][j] = INF;
            }
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a][b] = friends[b][a] = 1;
        }

        Solution s = new Solution(n, friends);
        int res = s.run();
        bw.write(res + "\n");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int[][] friends;

        public Solution(int n, int[][] friends) {
            this.n = n;
            this.friends = friends;
        }

        public int run() {
            for (int k = 1; k <= n; k++) {
                for (int j = 1; j <= n; j++) {
                    for (int i = 1; i <= n; i++) {
                        if (friends[i][j] > friends[i][k] + friends[k][j])
                            friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }

            int ans = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= n; j++) {
                    sum += friends[i][j];
                }
                if (ans > sum) {
                    ans = sum;
                    idx = i;
                }
            }
            return idx;
        }

    } // end of class
}
