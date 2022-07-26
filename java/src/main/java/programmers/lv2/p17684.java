package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p17684 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        p17684 p = new p17684();

        int[] result = p.solution(msg);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dict = new ArrayList<>(Arrays.asList("-ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")));
        StringBuilder w = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            w = new StringBuilder(Character.toString(msg.charAt(i)));

            for (int j = i+1; j < msg.length(); j++) {
                w.append(msg.charAt(j));
                if (!dict.contains(w.toString())) {
                    dict.add(w.toString());
                    answer.add(dict.indexOf(w.deleteCharAt(w.length()-1).toString()));
                    break;
                }

            }
            i += w.length()-1;
        }

        answer.add(dict.indexOf(w.toString()));

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }


}
