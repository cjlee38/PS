package programmers.undefined;

import java.util.*;

class p42627 {

    public static int solution(int[][] jobs) {

        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] <= o2[0]){
                return -1;
            }
            return 1;
        });

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] < o2[1]) {
                return -1;
            }
            return 1;
        });

        int time = 0;
        int index = 0;
        float answer = 0;

        while(true){
            while(index < jobs.length && jobs[index][0] <= time){
                queue.offer(jobs[index]);
                index ++;
            }
            if(queue.size() == 0){
                time = jobs[index][0];
                continue;
            }
            int[] job = queue.poll();
            time += job[1];
            answer += time - job[0];
            if(index == jobs.length && queue.size() == 0){
                break;
            }
        }

        answer /= jobs.length;
        return (int)answer;
    }
}