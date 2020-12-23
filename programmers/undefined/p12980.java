package programmers.undefined;

public class p12980 {
    public static void main(String[] args) {
        int n = 5;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        int count = 1;
        while(n != 1) {
            if (n % 2 == 1) {
                count++;
            }
            n = n/2;
        }

        return count;
    }
}
