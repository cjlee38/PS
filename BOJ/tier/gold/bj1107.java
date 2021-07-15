package BOJ.tier.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1107
 * name = 리모컨
 * tier = gold 5
 * date = 2021-07-14, 수, 16:21
 */

public class bj1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] brokens = new boolean[10];
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (m-- > 0) {
                brokens[pInt(st)] = true;
            }
        }


        Solution s = new Solution(n, brokens);
        int res = s.run();
        bw.write(res + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {
        private static final int INIT = 100;
        private int n;
        private boolean[] brokens;

        public Solution(int n, boolean[] brokens) {
            this.n = n;
            this.brokens = brokens;
        }

        public int run() {
            int min = Math.abs(n - INIT);
            for (int i = 0; i < 1_000_000; i++) {
                int nbr = getNumberPress(i);
                if (nbr > 0) {
                    int upDown = Math.abs(n - i);
                    min = Math.min(min, nbr + upDown);
                }
            }
            return min;
        }

        private int getNumberPress(int v) {
            int cnt = 0;
            if (v== 0)
                return brokens[0] ? 0 : 1;

            while (v > 0) {
                if (brokens[v % 10]) return 0;
                v /= 10;
                cnt++;
            }
            return cnt;
        }

    } // end of class
}
