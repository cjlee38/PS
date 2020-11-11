package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 - [1차] 캐시

public class p17680 {
    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        p17680 p = new p17680();
        int result = p.solution(cacheSize, cities);
        System.out.println(result);
    }

    public int solution(int cacheSize, String[] cities) {
        int runtime = 0;
        cities = lowerCities(cities);
        LinkedList<String> cache = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            int index = cache.indexOf(city);
            if (index >= 0) {
                cache.offer(cache.remove(index));
                runtime++;
            } else {
                runtime += 5;
                cache.offer(city);
                if (cache.size() > cacheSize) cache.poll();

            }
        }

        return runtime;
    }

    public String[] lowerCities(String[] org) {
        return Arrays.stream(org).map(String::toLowerCase).toArray(String[]::new);
    }
}
