package programmers.undefined;

public class p12940 {
    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        int[] result = solution(n, m);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        if (n > m) {
            int temp = m;
            m = n;
            n = temp;
        }
        answer[0] = getGCD(n, m);
        answer[1] = n*m / answer[0];
        return answer;
    }

    public static int getGCD(int n, int m) {
        while (m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }

}

