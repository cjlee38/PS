package programmers.lv2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

//프로그래머스 - 더 맵게
public class p42626 {
    public static void main(String[] args) {
        int[] socville = {1, 5};
        int K = 7;
        int result = solution(socville, K);
        System.out.println(result);
    }

    public static int solution(int[] scoville, int K) {
        int count = 0;

        PriorityQueue<Integer> foods = Arrays.stream(scoville)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        while (foods.size() > 1 && foods.peek() < K) {
            foods.offer(foods.poll() + foods.poll() * 2);
            count++;
        }

        return foods.peek() >= K ? count : -1;
    }
}
