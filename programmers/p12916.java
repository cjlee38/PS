package programmers;

// 프로그래머스 - 문자열 내 p와 y의 개수
public class p12916 {
    public static void main(String[] args) {
        String s = "pPoooyY";
        boolean result = solution(s);
        System.out.println(result);
    }

    static boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        return countChar(s, 'p') == countChar(s, 'y') ? true : false;
    }

    static int countChar(String s, char c) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

}
