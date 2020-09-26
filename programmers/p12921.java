package programmers;

import java.util.Arrays;

public class p12921 {
    public static void main(String[] args) {
        int n = 10;
        int result = solution(n);
        System.out.println(result);
    }
    public static int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i=2; i*i<=n; i++) {
            if (prime[i]) {
                for (int j = i*i; j<=n; j+=i) {
                    prime[j] = false;
                }
            }
        }

        for (int i=0; i<prime.length; i++) {
            if (prime[i]) {
                answer++;
            }
        }

        return answer;
    }


}
