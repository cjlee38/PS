package programmers;

public class p12900 {
    public static void main(String[] args) {
        int n = 4;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < n - 1; i++) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }

    public static int failedSolution(int n) {
        int answer = 0;
        int empty = n / 2 + 1;
        int vertical = 0;
        boolean isOdd = n % 2 != 0;

        if (isOdd) {
            vertical = 1;
        }

        while(empty >= 1) {
            answer += getNumOfCase(empty, vertical);
            empty--;
            vertical += 2;
        }

        return answer;
    }

    public static int getNumOfCase(int empty, int vertical) {
        int n = empty+vertical-1;
        int r = vertical;
        return factorial(n) / (factorial(n-r) * factorial(r));
    }

    public static int factorial(int n) {
        return n > 1 ? n * factorial(n-1) : 1;
    }
}
