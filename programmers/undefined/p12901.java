package programmers.undefined;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// 프로그래머스 - 2016년
public class p12901 {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        String answer = solution(a, b);
        System.out.println(answer);
    }

    public static String solution(int a, int b) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, a-1, b);
        String answer = new SimpleDateFormat("EEE", Locale.ENGLISH).format(calendar.getTime()).toUpperCase();

        return answer;
    }

}
