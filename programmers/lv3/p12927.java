package programmers.lv3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// 프로그래머스 - 야근 지수
public class p12927 {

    public static void main(String[] args) {
        int n = 4;
        int[] works = {4, 3, 3};
        long result = solution(n, works);
        System.out.println(result);
    }

    public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            PQ.offer(works[i]);
        }

        for (int i = 0; i < n; i++) {
            PQ.offer(PQ.poll()-1);
        }

        while(!PQ.isEmpty()) {
            long p = PQ.poll();
            answer += p > 0 ? Math.pow(p, 2) : 0;
        }

        return answer;


    }
}
