package programmers.undefined;

// 프로그래머스 - 약수의 합
public class p12928 {
    public static void main(String[] args) {
        int n = 12;
        int result = solution(n);
    }

    public static int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }
}