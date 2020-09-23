package programmers;

import java.util.HashMap;
import java.util.Map;

public class p42578 {
    public static void main(String[] args) {
        String clothes[][] = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        int answer = solution(clothes);
        System.out.println(answer);
    }
    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;
        for (String[] cloth : clothes) {
            map.compute(cloth[1], (k,v) -> v == null ? 1 : v + 1);
        }

        for (Integer value : map.values()) {
            answer *= (value+1);
        }


        return answer - 1;
    }


}
