package programmers;

// 프로그래머스 - 시저 암호
public class p12926 {
    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        String result = solution(s, n);
        System.out.println(result);
    }
    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                c = (char) ((c+n-'A') % 26 + 'A');
            } else if (Character.isLowerCase(c)) {
                c = (char) ((c+n-'a') % 26 + 'a');
            }
            sb.append(c);
        }

        return sb.toString();
    }

    // wow
//    return s.chars().map(c -> {
//        int n = _n % 26;
//        if (c >= 'a' && c <= 'z') {
//            return 'a' + (c - 'a' + n) % 26;
//        } else if (c >= 'A' && c <= 'Z') {
//            return 'A' + (c - 'A' + n) % 26;
//        } else {
//            return c;
//        }
//    }).mapToObj(c -> String.valueOf((char)c))
//            .reduce((a, b) -> a + b).orElse("");
}
