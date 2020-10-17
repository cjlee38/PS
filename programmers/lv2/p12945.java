package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class p12945 {


    public static void main(String[] args) {
        int n = 5;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        return recursive(n, map);
    }

    public static int recursive(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) return map.get(n);

        int cur = (recursive(n-1, map) + recursive(n-2, map)) % 1234567;
        map.put(n, cur);
        return cur;
    }
}
