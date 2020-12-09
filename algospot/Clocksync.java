package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Clocksync {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());
        Solution[] solutions = new Solution[loop];

        for (int i = 0; i < loop; i++) {
            int[] clockwises = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            solutions[i] = new Solution(clockwises);

        }

        for (Solution solution : solutions) {
            int result = solution.run();
            System.out.println(result);
        }

    }

    static class Solution {
        private static final int INF = 987654321;
        private static final int NUM_OF_CLOCKS = 16;
        private static final int NUM_OF_SWITCHES = 10;
        private static final int[][] linked = new int[][] {
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}
        };

        private int[] clockwises;


        public Solution(int[] clockwises) {
            this.clockwises = clockwises;
        }

        public int run() {
            return solve(0);
        }

        private boolean areAligned() {
            for (int i = 0; i < NUM_OF_CLOCKS; i++) {
                if (clockwises[i] != 12) return false;
            }

            return true;
        }

        private void push(int swtch) {
            for (int i = 0; i < NUM_OF_CLOCKS; i++) {
                if (linked[swtch][i] == 1) {
                    clockwises[i] += 3;
                    if (clockwises[i] == 15) clockwises[i] =3;
                }
            }
        }
        
        private int solve(int swtch) {
            if (swtch == NUM_OF_SWITCHES) return areAligned() ? 0 : INF;
            
            int result = INF;

            
            for (int i = 0; i < 4; i++) {
                result = Math.min(result, i + solve(swtch + 1));
                push(swtch);
            }
            
            return result;
        }
    }
}
