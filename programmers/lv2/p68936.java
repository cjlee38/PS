package programmers.lv2;

import java.util.Arrays;

public class p68936 {
    static int[][] board;
    static int[] answer;

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1},
        };

        int[] result = solution(arr1);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(int[][] arr) {
        board = arr;
        answer = new int[2];
        recursive(arr.length, 0, 0);
        return answer;
    }

    public static void recursive(int n, int x, int y) {
        if (isSame(n, x, y)) {
            accumulate(x, y);
        } else {
            int m = n / 2;
            recursive(m, x, y);
            recursive(m, x + m, y);
            recursive(m, x, y + m);
            recursive(m, x + m, y + m);
        }
    }

    public static boolean isSame(int n, int x, int y) {
        if (n == 1) return true;

        int num = board[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (num != board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void accumulate(int x, int y) {
        answer[board[x][y]]++;
    }
}
