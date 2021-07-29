package programmers.lv1;

public class p68935 {
    static final int MOD = 3;

    public static void main(String[] args) {
        int n = 45;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        while (n != 0) {
            sb.append(n % MOD);
            n = n / MOD;
        }

        sb = sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            answer += Character.getNumericValue(sb.charAt(i)) * Math.pow(MOD, i);
        }

        return answer;
    }
}
