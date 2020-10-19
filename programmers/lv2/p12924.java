package programmers.lv2;

public class p12924 {
    public static void main(String[] args) {
        int n = 15;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        int sum = 0, tail = 1, count = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
            while(sum >= n) {
                if (sum == n) count++;
                sum -= tail;
                tail++;
            }
        }

        return count;
    }
}
