package programmers.undefined;

import java.util.*;
import java.util.stream.IntStream;

public class p43163 {

    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int result = solution(begin, target, words);
        System.out.println(result);
    }

    public static int solution(String begin, String target, String[] words) {
        if (!isPossible(target, words)) {
            return 0;
        }

        visited = new boolean[words.length];
        int result = recursive(words, begin, target, 0);


        return result;
    }

    public static boolean isPossible(String target, String[] words) {
        return Arrays.stream(words)
                .filter(x -> x.equals(target))
                .count() == 1;
    }

    public static int recursive(String[] words, String begin, String target, int count) {
        if (begin.equals(target)) {
            return count;
        }

        boolean[] isOneCharDiffers = getOneCharDiffers(words, begin);
        int min = 0;
        for(int i=0; i<isOneCharDiffers.length; i++) {
            if (isOneCharDiffers[i] == true && visited[i] == false) {
                visited[i] = true;
                min = recursive(words, words[i], target, count + 1);
                visited[i] = false;
            }
        }
        return min;

    }

    public static boolean[] getOneCharDiffers(String[] words, String str) {
        boolean[] isOneCharDiifers = new boolean[words.length];
        for (int i=0; i<words.length; i++) {
            if (compareChars(words[i], str) == 1) {
                isOneCharDiifers[i] = true;
            }
        }

        return isOneCharDiifers;
    }

    public static int compareChars(String str1, String str2) {
        return (int) IntStream.range(0, str1.length())
                .filter(i -> str1.charAt(i) != str2.charAt(i))
                .count();
    }
}
