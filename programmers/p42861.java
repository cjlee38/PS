package programmers;

import java.util.*;


// ***
// 프로그래머스 - 섬 연결하기
public class p42861 {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {
                {0, 1, 1},
                {0, 2, 2},
                {1, 2, 5},
                {1, 3, 1},
                {2, 3, 8}
        };
        int answer = solution(n, costs);
        System.out.println(answer);

    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        for(int i=0; i<costs.length; i++) {
            if (!findParent(parent, costs[i][0], costs[i][1])) {
                unionParent(parent, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }

        return answer;
    }

    public static boolean findParent(int parent[], int x, int y) {
        x = getParent(parent, x);
        y = getParent(parent, y);

        if (x == y) return true;
        else return false;
    }

    public static void unionParent(int[] parent, int x, int y) {
        x = getParent(parent, x);
        y = getParent(parent, y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    public static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x;
        return getParent(parent, parent[x]);
    }


}