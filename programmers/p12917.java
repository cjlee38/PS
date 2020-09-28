package programmers;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 프로그래머스 - 문자열 내림차순으로 배치하기
public class p12917 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        String result = solution(s);
        System.out.println(result);
    }

    public static String solution(String s) {
        return Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
}
