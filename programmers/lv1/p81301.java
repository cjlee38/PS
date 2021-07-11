package programmers.lv1;

import java.util.*;

public class p81301 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        Solution sol = new Solution();
        int res = sol.solution(s);
        System.out.println(res);
    }
    static class Solution {
        public int solution(String s) {
            Map<String, String> convertMap = new HashMap<>();
            convertMap.put("zero", "0");
            convertMap.put("one", "1");
            convertMap.put("two", "2");
            convertMap.put("three", "3");
            convertMap.put("four", "4");
            convertMap.put("five", "5");
            convertMap.put("six", "6");
            convertMap.put("seven", "7");
            convertMap.put("eight", "8");
            convertMap.put("nine", "9");

            for (Map.Entry<String, String> entry : convertMap.entrySet()) {
                s = s.replace(entry.getKey(), entry.getValue());
            }
            return Integer.parseInt(s);
        }
    }
}
