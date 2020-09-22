package programmers;

import java.util.*;

public class p42895 {

    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        int answer = solution(N, number);
        System.out.println(answer);
    }

    public static int solution(int N, int number) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        int count = 0;

        while(count <= 8) {
            count++;

        }
        if (count > 8) {
            count = -1;
        }

        int answer = count;
        return answer;
    }

    static void getCombinations(Map<Integer, HashSet<Integer>> map, int count, int N) {
        if (count == 1) {
            map.put(1, new HashSet<Integer>(Arrays.asList(N)));
        } else {
            
        }
    }

    static int getConcatenation(int count, int N) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            sb.append(N);
        }
        return Integer.parseInt(sb.toString());
    }


    static Set<Integer> getCalculations(Set<Integer> set, int N) {
        Set<Integer> newSet = new HashSet<>();
        for(Integer e : set) {
            newSet.add(e + N);
            newSet.add(e - N);
            newSet.add(e / N);
            newSet.add(e * N);
        }

        return newSet;
    }




}
