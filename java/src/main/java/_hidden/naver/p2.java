package _hidden.naver;

import java.util.*;
import java.util.stream.Collectors;

public class p2 {
    public static void main(String[] args) {
//        int N = 5;
//        int[] A = {2, 2, 1, 2};
//        int[] B = {1, 3, 4, 4};

        int N = 3;
        int[] A = {1, 2, 3};
        int[] B = {2, 3, 1};

        Solution s = new Solution();
        int solution = s.solution(N, A, B);
        System.out.println(solution);
    }

    static class Solution {
        public int solution(int N, int[] A, int[] B) {
            int M = A.length;
            Map<Integer, List<Integer>> G = new LinkedHashMap<>();
            for (int i = 1; i <= N; i++) {
                G.put(i, new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                G.get(A[i]).add(B[i]);
                G.get(B[i]).add(A[i]);
            }
            LinkedHashMap<Integer, List<Integer>> G2 = sort(G);
            int[] values = new int[N];
            int value = 1;
            for (Map.Entry<Integer, List<Integer>> entry : G2.entrySet()) {
                values[entry.getKey() - 1] = value++; // index
            }
            int ans = 0;
            for (int i = 0; i < M; i++) {
                ans += values[A[i] - 1] + values[B[i] - 1];
            }
            System.out.println(Arrays.toString(values));

            return ans;
        }

        public LinkedHashMap<Integer, List<Integer>> sort(Map<Integer, List<Integer>> map) {
            List<Map.Entry<Integer, List<Integer>>> entries = new LinkedList<>(map.entrySet());
            entries.sort(Comparator.comparingInt(o -> o.getValue().size()));

            LinkedHashMap<Integer, List<Integer>> result = new LinkedHashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : entries) {
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        }
    }
}
