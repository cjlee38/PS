package BOJ;

import java.util.Scanner;
import java.util.HashMap;

public class p2457 {

    public static int getCalendarDate(String month, String date) {
        return (Integer.parseInt(month) * 100) + Integer.parseInt(date);

    }

    public static void main(String[] args) {
        final int START_DATE = 301;
        final int END_DATE = 1201;
        
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int count = 0;
        
        HashMap<Integer, Integer> flower = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] rawDate = sc.nextLine().split(" ");
            int start = getCalendarDate(rawDate[0], rawDate[1]); 
            int end = getCalendarDate(rawDate[2], rawDate[3]);
            
            if (flower.get(start) == null || flower.get(start) < end) { // 기존의 end가 새로운 end보다 짧다면 
                flower.put(start, end);
            }
        }
        
        boolean flag = false;
        int current = START_DATE;
        while (current < END_DATE) {
            int max = current;
            for (int key : flower.keySet()) {
                if (key <= current && max < flower.get(key)) {
                    max = flower.get(key);
                    flag = true;
                }
            }

            if (flag) {
                current = max;
                flag = false;
                count++;
            } else {
                count = 0;
                break;
            }
            
        }
        // Case 1. 정상적으로 연결되는 경우(3월1일 이전부터 ~ 12월1일까지)
        // Case 2. 한번에 연결되는 경우(e.g. 2월1일 ~ 12월 31일까지)

        // Case 3. 앞쪽이 없는 경우 (모든 시작일이 3월1일 이후)
        // Case 4. 중간에 연결이 안되는 경우
        // Case 5. 끝이 없는 경우 (모든 종료일이 11월 30일 이전)

        // trivial 1. 2 (1 5 5 20) (5 20 12 20)
        // trivial 2. 3 (1 5 5 20) (5 20 5 21) (5 21 12 20)
        System.out.println(count);
        sc.close();
    }

}