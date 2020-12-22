package algospot;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fanmeeting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int c = Integer.parseInt(st.nextToken());
        Solution[] solutions = new Solution[c];
        for(int i = 0; i < c; i++) {
            final int[] members = Arrays.stream(br.readLine().split("")).mapToInt((String str) -> str.equals("M") ? 0 : 1).toArray();
            final int[] fans = Arrays.stream(br.readLine().split("")).mapToInt((String str) -> str.equals("M") ? 0 : 1).toArray();
            solutions[i] = new Solution(members, fans);
        }

        for (Solution solution : solutions) {
            int result = solution.solve();
            System.out.println(result);
        }
    }

    static class Solution {
        private int[] members;
        private int[] fans;

        public Solution(int[] members, int[] fans) {
            this.members = members;
            this.fans = fans;
        }

        public int solve() {

            return -1;
        }
    }
}
