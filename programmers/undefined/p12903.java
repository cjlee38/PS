package programmers.undefined;

// 프로그래머스 - 가운데 글자 가져오기
public class p12903 {
    public static void main(String[] args) {
        String s = "qwer";
        String answer = solution(s);
        System.out.println(answer);
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() % 2 == 0) {
            sb.append(s.charAt(s.length()/2-1));
        }

        return sb.append(s.charAt(s.length()/2)).toString();
    }
}
