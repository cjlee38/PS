package programmers.lv1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 프로그래머스 - [1차] 다트 게임
public class p17682 {
    public static void main(String[] args) {
        String dartResult = "1D2S#10S";

        p17682 p = new p17682();
        int result = p.solution(dartResult);
        System.out.println(result);
    }

    public int solution(String dartResult) {
        List<Integer> scores = new ArrayList<>();

        char[] charArray = dartResult.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            StringBuilder sb = new StringBuilder();
            while(Character.isDigit(charArray[i])) {
                sb.append(charArray[i]);
                i++;
            }
            if (sb.length() != 0) {
                scores.add(Integer.parseInt(sb.toString()));
            }
            char ch = charArray[i];

            if (Character.isLetter(ch)) {
                handleLetter(scores, ch);
            } else {
                handleSpecial(scores, ch);
            }
        }

        return scores.stream().mapToInt(Integer::intValue).sum();
    }

    private void handleSpecial(List<Integer> scores, char ch) {
        Integer first;
        if (ch == '*') {
            first = scores.remove(scores.size() - 1) * 2;

            if (scores.size() >= 1) {
                Integer second = scores.remove(scores.size() - 1) * 2;
                scores.add(second);
            }

        } else {
            first = scores.remove(scores.size() - 1) * -1;
        }
        scores.add(first);
    }


    private void handleLetter(List<Integer> scores, char ch) {
        Integer value = scores.remove(scores.size() - 1);

        if (ch == 'D') value = (int) Math.pow(value, 2);
        else if (ch == 'T') value = (int) Math.pow(value, 3);

        scores.add(value);
    }
}
