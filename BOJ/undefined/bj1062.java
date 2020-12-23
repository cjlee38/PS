package BOJ.undefined;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1062 {
    static Solution1062 init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 5;


        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        return new Solution1062(words, K);
    }

    public static void main(String[] args) throws IOException {
        Solution1062 solution1062 = init();
        int result = solution1062.run();
        System.out.println(result);
    }
}

class Solution1062 {
    final static private int SMALL_ASCII = 97;
    private final String[] words;
    private boolean[] aphbs;
    private int K;

    private int maxNumOfReadable;

    public Solution1062(String[] words, int k) {
        this.words = words;
        K = k;
        aphbs = initAphbs();
        maxNumOfReadable = Integer.MIN_VALUE;
    }

    private boolean[] initAphbs() {
        boolean[] aphbs = new boolean[26];
        aphbs['a' - 97] = true;
        aphbs['n' - 97] = true;
        aphbs['t' - 97] = true;
        aphbs['i' - 97] = true;
        aphbs['c' - 97] = true;

        return aphbs;
    }

    public int run() {
        String[] middleWords = Arrays.stream(words)
                .map(x -> x.substring(4, x.length() - 4).replaceAll("[antic]", ""))
                .toArray(String[]::new);
        String[] restAphbs = Arrays.stream(middleWords)
                .map(x -> x.split(""))
                .flatMap(Arrays::stream)
                .filter(x -> !Arrays.asList("a", "n", "t", "i", "c").contains(x))
                .toArray(String[]::new);

        if (restAphbs.length == 0 || K < 0) {
            return 0;
        }

        recursive(middleWords, restAphbs, 0, 0);


        return maxNumOfReadable;
    }

    private void recursive(String[] middleWords, String[] restAphbs, int idx, int count) {
        if (count == K) {
            maxNumOfReadable = Math.max(maxNumOfReadable, getNumOfReadableWords(middleWords));
            return;
        }


        for (int i=idx; i<restAphbs.length; i++) {
            char cur = restAphbs[i].charAt(0);
            aphbs[cur - SMALL_ASCII] = true;
            recursive(middleWords, restAphbs, idx+1, count+1);
            aphbs[cur - SMALL_ASCII] = false;
        }

    }

    private int getNumOfReadableWords(String[] middleWords) {
        int numOfReadable = 0;
        char[] curChars = getCurrentChars();

        for(String middleWord : middleWords) {
            if(isReadable(middleWord, curChars)) {
                numOfReadable++;
            }
        }

        return numOfReadable;
    }

    private boolean isReadable(String middleWord, char[] curChars) {
        String temp = middleWord;
        for (char curChar : curChars) {
            temp = temp.replace(String.valueOf(curChar), "");
        }

        return temp.equals("");
    }

    private char[] getCurrentChars() {
        int index = 0;
        char[] curChars = new char[K];

        for (int i=0; i<aphbs.length; i++) {
            char aphb = (char)(i + SMALL_ASCII);
            if (aphbs[i] && !Arrays.asList('a', 'n', 't', 'i', 'c').contains(aphb)) {
                curChars[index] = aphb;
                index++;
            }
        }

        return curChars;
    }



}
