package programmers.lv2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class p12951 {
    public static void main(String[] args) {
        String s = "3people unFollowed   me";
        String result = solution(s);
        System.out.println(result);
    }

    public static String solution(String s) {
        String str = Arrays.stream(s.split(" "))
                .map(String::toLowerCase)
                .map(x -> toCamelCase(x))
                .collect(Collectors.joining(" "));
        return  s.charAt(s.length()-1) == ' ' ? str + " " : str;
    }

    public static String toCamelCase(String str) {
        return str.length() >= 1 ? str.substring(0, 1).toUpperCase() + str.substring(1) : "";
    }
}
