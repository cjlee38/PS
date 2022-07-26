package programmers.unsolved;

import java.util.*;

public class p42895 {
    static final int MAX_COUNT = 8;

    public static void main(String[] args) {
        int N = 2;
        int number = 22224;

        int answer = solution(N, number);
        System.out.println(answer);
    }

    public static int solution(int N, int number) {
        int count = 0;
        Set<Integer> combs = new HashSet<>();
        combs.add(N);

        while (count <= MAX_COUNT) {
            count++;
            getCombination(combs, count, N);
            if (combs.contains(number)) {
                return count;
            }
        }
        return -1;
    }

    public static void getCombination(Set<Integer> combs, int count, int N) {
        if (count == 1) {
            combs.add(N);
            return;
        }

        combs.addAll(createNewCombs(combs, count, N));
    }

    public static Set<Integer> createNewCombs(Set<Integer> combs, int count, int N) {
        Set<Integer> newCombs = new HashSet<>();

        newCombs.add(concat(count, N));
        newCombs.addAll(calc(combs, N));

        return newCombs;
    }

    public static int concat(int count, int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < count; i++) {
            sb.append(N);
        }

        return Integer.parseInt(sb.toString());
    }

    public static Set<Integer> calc(Set<Integer> combs, int N) {
        Set<Integer> calcComb = new HashSet<>();

        for (Integer em : combs) {
            calcComb.add(em + N);
            calcComb.add(em - N);
            calcComb.add(em / N);
            calcComb.add(em * N);
        }

        return calcComb;
    }

}
