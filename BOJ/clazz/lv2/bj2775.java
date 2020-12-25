package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2775
 * name = 부녀회장이 될테야
 */

public class bj2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Solution s = new Solution();
        s.run();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(s.get(k, n) + "\n");
        }


        bw.flush();
        bw.close();
    }

    static class Solution {
        private static final int SIZE = 15;
        private int[][] apart;

        public void run() {
            apart = new int[SIZE][SIZE];

            for(int i = 0; i < SIZE; i++) {
                apart[0][i] = i;
                apart[i][1] = 1;
            }

            for (int i = 1; i < SIZE; i++) {
                for(int j = 2; j < SIZE; j++) {
                    apart[i][j] = apart[i][j-1] + apart[i-1][j];
                }
            }
        }

        public int get(int k, int n) {
            return apart[k][n];
        }
    }
}
