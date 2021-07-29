package programmers.lv1;

import java.util.Arrays;

public class p12918 {
    public static void main(String[] args) {

    }

    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && isDigit(s);
    }

    private boolean isDigit(String s) {
        return s.chars().filter(x -> !Character.isDigit(x)).count() == 0;
    }
}
