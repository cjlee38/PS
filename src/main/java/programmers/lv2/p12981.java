package programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p12981 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] result = solution(n, words);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            int[] pos = calcPos(i, n);
            boolean flag = addWord(list, words[i]);

            if (!flag) return pos;
        }

        return new int[]{0, 0};

    }

    public static int[] calcPos(int iter, int n) {
        return new int[]{
                (iter % n) + 1, // 번호
                (iter / n) + 1
        };
    }

    public static boolean addWord(List<String> list, String word) {
        if (list.size() == 0) {
            list.add(word);
            return true;
        }

        String lastWord = list.get(list.size()-1);
        char lastChar = lastWord.charAt(lastWord.length()-1);

        if (!list.contains(word) && lastChar == word.charAt(0)) {
            list.add(word);
            return true;
        }

        return false;
    }
}
