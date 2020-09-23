package programmers;

import java.util.*;

// 프로그래머스 - 스킬트리
public class p49993 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        
        int answer = solution(skill, skill_trees);
        System.out.println(answer);
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char c = skill.charAt(0);
        for (int i=0; i<skill_trees.length; i++) {
            boolean flag = true;
            int idx = skill_trees[i].indexOf(c);

            for (int j=1; j<skill.length(); j++) {
                if (skill_trees[i].indexOf(skill.charAt(j)) < idx) {
                    flag = false;
                }
            }

            if (flag == true) answer++;
        }


        return answer;
    }
}
