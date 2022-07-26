package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class p42576 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        p42576 p = new p42576();
        String answer = p.solution(participant, completion);
        System.out.println(answer);
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> parts = new HashMap<>();

        for (String p : participant) {
            parts.compute(p, (k, v) -> v == null ? 1 : v + 1);
        }

        for (String c : completion) {
            parts.computeIfPresent(c, (k, v) -> v -1);
        }

        return parts.entrySet()
                .stream()
                .filter(x -> x.getValue() != 0)
                .findFirst()
                .get()
                .getKey();

    }
}
