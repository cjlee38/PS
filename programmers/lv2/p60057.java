package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class p60057 {
    public static void main(String[] args) {
//        String s = "abcabcabcabcdededededede";
//        String s = "xababcdcdababcdcd";
//        String s = "abcabcdede";
//        String s = "aaabb";
        String s = "ab";
        p60057 p = new p60057();
        final int result = p.solution(s);
        System.out.println("result = " + result);
    }

    public int solution(String s) {
        if (s.length() == 1) return 1;

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length() / 2; i++) {
            List<String> splited = split(s, i);
            String compressed = compress(splited);
            min = Math.min(min, compressed.length());
        }

        return min;
    }

    public String compress(List<String> splited) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splited.size(); ) {
            String current = splited.get(i);
            int count = count(splited, current, i);

            if (count > 1) {
                sb.append(count);
            }
            i += count;
            sb.append(current);

        }

        return sb.toString();
    }

    public int count(List<String> splited, String current, int index) {
        int count = 1;

        while(index+1 < splited.size() && current.equals(splited.get(index+1))) {
            index++;
            count++;
        }
        return count;
    }

    public List<String> split(String s, int len) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i += len) {
            if (i+len > s.length()) result.add(s.substring(i));
            else result.add(s.substring(i, i + len));
        }

        return result;
    }
}
