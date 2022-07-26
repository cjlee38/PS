package programmers.lv2;

import java.util.Arrays;

// 프로그래머스 - 스킬트리
public class p49993 {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int result = solution(skill, skill_trees);
        System.out.println(result);
    }

    public static int solution(String skill, String[] skill_trees) {
        String regex = "[^" + skill + "]";

        return (int) Arrays.stream(skill_trees)
                .map(x -> x.replaceAll(regex, ""))
                .filter(x -> isOrdered(skill, x))
                .count();
    }

    public static boolean isOrdered(String skill, String skill_tree) {
        return skill.indexOf(skill_tree) == 0;
//        int prev = -1;
//
//        for (int i = 0; i < skill_tree.length(); i++) {
//            char c = skill_tree.charAt(i);
//            int cur = skill.indexOf(c); // cur = 1, prev = 0, 1 < 0
//
//            if (prev != cur-1) return false;
//            else prev = cur;
//        }
//
//        return true;
    }


}
