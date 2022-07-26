package programmers.lv2;

import java.util.Arrays;

public class p12977 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};

        p12977 p = new p12977();
        int result = p.solution(nums);
        System.out.println(result);
    }

    public int solution(int[] nums) {
        boolean[] primes = getPrimeArray();

        int count = recursive(nums, primes, 0, 0, 0);
        return count;
    }

    public int recursive(int[] nums, boolean[] primes, int index, int count, int acc) {
        if (count == 3) return primes[acc] ? 1 : 0;

        int sum = 0;
        for(int i = index; i < nums.length; i++) {
            sum += recursive(nums, primes, i+1, count+1, acc+nums[i]);
        }

        return sum;
    }

    public boolean[] getPrimeArray() {
        boolean[] primes = new boolean[3001];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i=2; i*i<=3000; i++) {
            if (primes[i]) {
                for (int j = i*i; j<=3000; j+=i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }
}
