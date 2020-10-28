package programmers.lv2;

// 프로그래머스 - 예상대진표
public class p12985 {
    public static void main(String[] args) {
        int n = 8;
        int a = 3;
        int b = 5;


        System.out.println(solution(n, a, b));
        System.out.println(solution2(n, a, b));
    }

    public static int solution(int n, int a, int b) {
        return Integer.toBinaryString(a^b).length();
    }

    public static int solution2(int n, int a, int b) {
        int answer = 0;
        while (a != b) {
            b = b % 2 == 1 ? b / 2 + 1 : b / 2;
            a = a % 2 == 1 ? a / 2 + 1 : a / 2;
            answer++;
        }
        return answer;
    }
}
