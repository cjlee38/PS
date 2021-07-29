package programmers.undefined;

public class p12911 {
    public static void main(String[] args) {
        int n = 78;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        int bitCount = Integer.bitCount(n);

        while(true) {
            n++;
            if (Integer.bitCount(n) == bitCount) {
                break;
            }
        }
        return n;
    }
}
