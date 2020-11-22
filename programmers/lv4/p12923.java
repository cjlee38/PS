package programmers.lv4;

import java.util.ArrayList;
import java.util.List;

public class p12923 {
    public static void main(String[] args) {
        long begin = 990000000;
        long end = 990010000;

        List<Long> list = new ArrayList<>();
        p12923 p = new p12923();
        for (int i = 0; i < 10; i++) {
            long s = System.currentTimeMillis();
            int[] answer = p.solution(begin, end);
            long e = System.currentTimeMillis();

            list.add(e - s);
        }

        double elapsed = list.stream().mapToLong(Long::longValue).average().getAsDouble();
        System.out.println("elapsed = " + elapsed);
    }

    public int[] solution(long begin, long end) {
        int n = (int) (end - begin + 1);
        int[] road = new int[n];

        for (int i = 0; i < n; i++) {
            int cur = (int) (begin + i);
            road[i] = getGD(cur);
        }

        if (begin == 1) road[0] = 0;
        return road;
    }

    private int getGD(int cur) {
        for (int i = 2; i <= Math.sqrt(cur); i++) {
            if (cur % i == 0 && (cur / i) < 10000000) {
                return cur / i;
            }
        }

        return 1;
    }
}
