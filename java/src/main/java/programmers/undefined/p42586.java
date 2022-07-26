package programmers.undefined;

import java.util.*;

public class p42586 {
    public static void main(String[] args) {

//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
        int[] progresses = {95, 90, 99, 99, 80, 99}; // 5 10 1 1 20 1
        int[] speeds = {1, 1, 1, 1, 1, 1}; // 1 3 2
//        int[] progresses = {93, 97, 95, 91};
//        int[] speeds = {1, 1, 1, 1};


        int[] answer = solution(progresses, speeds);
        for(int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new LinkedList<>();

        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i=0; i<progresses.length; i++) {
            int elapsed = getDate(progresses[i], speeds[i]);
            if (i == 0) max = elapsed;
            if (i != 0 && max < elapsed) {
                list.add(cnt);
                cnt = 0;
                max = elapsed;
            }
            cnt++;
        }
        list.add(cnt);

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int getDate(int p, int s) {
        int cnt = 0;
        while(p < 100) {
            p += s;
            cnt++;
        }
        return cnt;
    }
}
