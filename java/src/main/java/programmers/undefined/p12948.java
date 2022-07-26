package programmers.undefined;

import org.w3c.dom.ls.LSOutput;

public class p12948 {
    public static void main(String[] args) {
        String phone_number = "01033334444";
        String result = solution(phone_number);
        System.out.println(result);
    }

    public static String solution(String phone_number) {
        return "*".repeat(phone_number.length()-4) + phone_number.substring(phone_number.length()-4);
    }

}
