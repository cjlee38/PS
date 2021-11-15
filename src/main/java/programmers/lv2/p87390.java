package programmers.lv2;

import java.util.Arrays;
import java.util.stream.LongStream;

public class p87390 {

    public static void main(String[] args) {
        int n = 4;
        long left = 7;
        long right = 14;
        Solution s = new Solution();
        int[] res = s.solution(n, left, right);
        System.out.println(Arrays.toString(res));
    }

    static class Solution {
        public int[] solution(int n, long left, long right) {
            return LongStream.rangeClosed(left, right)
                    .mapToInt(i -> (int) (Math.max((i % n), (i / n)) + 1))
                    .toArray();
        }
    }
}
