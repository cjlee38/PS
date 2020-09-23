package programmers;

import java.util.HashMap;
import java.util.Map;

public class sc1 {

    public static void main(String[] args) {
//        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
//        String[] answer = solution( record);
//        for(String s : answer) {
//            System.out.println(s);
//        }
        int[] answer = solution2(10, 2);
        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }
    public static String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<record.length; i++) {
            String[] str = record[i].split(" ");
            if (!str[0].equals("Leave")) {
                map.put(str[1], str[2]);
                count++;
            }
        }

        String[] answer = new String[count];
        for (int i=0; i<record.length; i++) {
            String[] str = record[i].split(" ");
            if (str[0].equals("Enter")) {
                answer[i] = map.get(str[1]) + "님이 들어왔습니다.";
            } else if (str[0].equals("Leave")) {
                answer[i] = map.get(str[1]) + "님이 나갔습니다.";
            }
        }


        return answer;
    }
    public static int[] solution2(int brown, int yellow) {
        int x = -1;
        int y = -1;
        int sum = brown+yellow;

        for (int i=1; i<sum; i++) {
            if (sum%i == 0 && (i*2) + ((sum/i)*2) - 4 == brown) {
                x = i;
                y = sum/i;
                break;
            }
        }

        return new int[]{Math.max(x, y), Math.min(x, y)};
    }

}
