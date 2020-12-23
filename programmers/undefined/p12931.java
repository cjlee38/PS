package programmers.undefined;

public class p12931 {
    public static void main(String[] args) {
        int n = 987;
        int result = solution(n);
        System.out.println(result);

    }

    public static int solution(int n) {
        return String.valueOf(n).chars().map(x -> Character.getNumericValue(x)).sum();
    }

}