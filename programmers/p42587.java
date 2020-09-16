package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p42587 {
    public static void main(String[] args) {

        // case 1
//        int[] priorities = {2, 1, 3, 2};
//        int location = 2;

        // case 2
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int answer = solution(priorities, location);
        System.out.println(answer);

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            q.offer(priorities[i]);
        }

        while (!q.isEmpty()) {
            boolean prior = isPrior(q, q.peek());
            if (prior) {
                q.poll();
                answer++;
            } else {
                q.offer(q.poll());
            }
            location = getLocation(location, prior, q);
            if (location == -1) break;
        }

        return answer;
    }

    public static boolean isPrior(Queue<Integer> q, int value) {
        return q.stream().filter(x -> value < x).count() > 0 ? false : true;
    }

    public static int getLocation(int location, boolean prior, Queue<Integer> q) {
        int loc;
        if (location == 0 && prior) { // time to out !
            loc = -1;
        } else if (location == 0 && !prior) { // go to tail
            loc = q.size()-1;
        } else { // location is not head currently
            loc = location-1;
        }

        return loc;
    }

}
