package _hidden.programmers.montly42_2;

import java.util.Arrays;

public class p1 {

    static class Solution {
        public int solution(int left, int right) {
            int[] counts = new int[1000 + 1];
            long ans = 0;
            for (int i = 1; i <= 1000; i++)
                for (int j = 1; j <= 1000 / i; j++)
                    counts[i * j]++;
            for (int i = left; i <= right; i++)
                ans += counts[i] % 2 == 0 ? i : i * -1;

            return (int)ans;
        }
    }
}
