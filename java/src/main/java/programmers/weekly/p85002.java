package programmers.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p85002 {

    public static void main(String[] args) {
        int[] weights = {50, 82, 75, 120};
        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};

        Solution s = new Solution();
        int[] res = s.solution(weights, head2head);
        System.out.println(Arrays.toString(res));
    }

    static class Solution {
        public int[] solution(int[] weights, String[] head2head) {
            int len = weights.length;
            List<Boxer> boxers = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                int number = i + 1;
                int weight = weights[i];

                int win = 0;
                int game = 0;
                int winToHeavy = 0;
                for (int j = 0; j < head2head[i].length(); j++) {
                    char c = head2head[i].charAt(j);
                    if (c == 'N')
                        continue;
                    ++game;
                    if (c == 'L')
                        continue;
                    if (c == 'W') {
                        ++win;
                        if (weights[j] > weight)
                            ++winToHeavy;
                    }
                }
                double winRate = game == 0 ? 0 : (double) win / game;
                Boxer boxer = new Boxer(number, weight, winRate, winToHeavy);
                boxers.add(boxer);
            }
            Collections.sort(boxers);
            System.out.println(boxers);
            return boxers.stream().mapToInt(x -> x.number).toArray();
        }
    }

    static class Boxer implements Comparable<Boxer> {
        @Override
        public String toString() {
            return "Boxer{" +
                    "number=" + number +
                    ", weight=" + weight +
                    ", winRate=" + winRate +
                    ", winToHeavy=" + winToHeavy +
                    '}';
        }

        private int number; // 복서 번호(index starts with 1)
        private int weight;
        private double winRate;
        private int winToHeavy;

        public Boxer(int number, int weight, double winRate, int winToHeavy) {
            this.number = number;
            this.weight = weight;
            this.winRate = winRate;
            this.winToHeavy = winToHeavy;
        }

        @Override
        public int compareTo(Boxer o) {
            if (this.winRate != o.winRate) {
                if (o.winRate > this.winRate)
                    return 1;
                return -1;
            }
            if (this.winToHeavy != o.winToHeavy)
                return o.winToHeavy - this.winToHeavy;
            if (this.weight != o.weight)
                return o.weight - this.weight;
            return this.number - o.number;
        }
    }
}
