package programmers.undefined;

import java.util.Arrays;
import java.util.Comparator;


// 프로그래머스 - 문자열 내 마음대로 정렬하기
public class p12915 {
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        
//        String[] strings = {"abce", "abcd", "cdx"};
//        int n = 2;
        String[] answer = solution(strings, n);
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Character c1 = o1.charAt(n);
                Character c2 = o2.charAt(n);
                return c1 == c2 ? o1.compareTo(o2) : c1.compareTo(c2);
            }
        });

        return strings;
    }
}
