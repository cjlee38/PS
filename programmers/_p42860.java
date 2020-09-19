package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스 - 조이스틱
public class _p42860 {
    public static void main(String[] args) {
        String name = "BBAABAA";
        int answer = solution(name);
        System.out.println(answer);
    }


    public static int solution(String name) {
        int answer = 0;

        for (int i=0; i<name.length(); i++) {
            answer += getMinUpDown(name.charAt(i));

            if (name.charAt(i) != 'A') {
                int j = i+1;
                while (j < name.length() && name.charAt(j) == 'A') {
                    j++;
                }

                int distance = j < name.length() ? Math.min(j-i, name.length()-(j-i)) : 0;
                answer += distance;
                System.out.println(distance);
            }



        }
        return answer;
    }

    public static int getMinUpDown(char alpha) {
        return Math.min(alpha-'A', 'Z'-alpha+1);
    }

}
