package programmers;

public class p12934 {
    public static void main(String[] args) {
        long n = 121;
        long result = solution(n);
        System.out.println(result);

    }

    public static long solution(long n) {
        return Math.floor(Math.sqrt(n)) == Math.sqrt(n) ? (long) Math.pow(Math.sqrt(n) + 1, 2) : -1;

    }

}