package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 - [1차] 뉴스 클러스터링
public class p17677 {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";

        int result = solution(str1, str2);
        System.out.println(result);
    }

    public static int solution(String str1, String str2) {

        Map<String, Integer> map1 = createMap(str1);
        Map<String, Integer> map2 = createMap(str2);

        System.out.println("map1 = " + map1);
        System.out.println("map2 = " + map2);

        // 두 다중집합이 공집합인 경우, 자카드 유사도는 1로 판단.
        if (map1.isEmpty() && map2.isEmpty()) return 65536;

        int intersection = getIntersectionCount(map1, map2);
        int union = getUnionCount(map1, map2);

        System.out.println("intersection = " + intersection);
        System.out.println("union = " + union);

        return (int) Math.floor(((double) intersection / union) * 65536);
    }

    public static Map<String, Integer> createMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        str = str.toLowerCase();

        for (int i = 2; i <= str.length(); i++) {
            String temp = str.substring(i - 2, i);
            if (isAlpha(temp)) map.compute(temp, (k, v) -> v == null ? 1 : v + 1);
        }

        return map;
    }

    public static boolean isAlpha(String str) {
        return str.matches("^[a-z]*$");
    }

    public static int getUnionCount(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> union = new HashMap<>(map1);
        map2.forEach((k, v) -> union.merge(k, v, (v1, v2) -> v1 > v2 ? v1 : v2));

        return union.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static int getIntersectionCount(Map<String, Integer> map1, Map<String, Integer> map2) {
        return map1.entrySet()
                .stream()
                .filter(x -> map2.containsKey(x.getKey()))
                .mapToInt(x -> Math.min(x.getValue(), map2.get(x.getKey())))
                .sum();
    }

}
