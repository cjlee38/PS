package programmers;

// 프로그래머스 - 하샤드 수
public class p12947 {
    public static void main(String[] args) {
        int x = 18;
        boolean result = solution(x);
        System.out.println(result);
    }
    public static boolean solution(int x) {
        return x % String.valueOf(x).chars().map(Character::getNumericValue).sum() == 0;
    }
}
