package programmers.undefined;

public class p12932 {
    public static void main(String[] args) {
        long n = 12345;
        int[] result = solution(n);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public static int[] solution(long n) {
        return new StringBuilder(String.valueOf(n))
                .reverse()
                .toString()
                .chars()
                .map(x -> Character.getNumericValue(x))
                .toArray();
    }

}