package _hidden.kakao.internshipSummer;

import java.util.HashMap;
import java.util.Map;

public class p1 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        Map<String, Integer> map = new HashMap<>();
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                sb.append(c);
            else {

            }
        }
    }
}
