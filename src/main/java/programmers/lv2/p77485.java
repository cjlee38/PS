package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class p77485 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        Solution s = new Solution();
        int[] answer = s.solution(rows, columns, queries);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    static class Solution {
        private int[][] map;
        private int rows;
        private int columns;
        private int[][] queries;

        public int[] solution(int rows, int columns, int[][] queries) {
            init(rows, columns, queries);
            int[] answer = exec();

            return answer;
        }

        private void init(int rows, int columns, int[][] queries) {
            this.rows = rows;
            this.columns = columns;
            this.queries = queries;
            int[][] map = new int[rows][columns];
            int v = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    map[i][j] = ++v;
                }
            }
            this.map = map;
        }

        private int[] exec() {
            int[] rets = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int ret = rotate(query);
                rets[i] = ret;
            }
            return rets;
        }

        private int rotate(int[] query) {
            List<Integer> mins = new ArrayList<>();
            int y1 = query[0] - 1, x1 = query[1] - 1;
            int y2 = query[2] - 1, x2 = query[3] - 1;

            int topleft = map[y1][x1];

            for (int i = y1; i < y2; i++) {
                map[i][x1] = map[i + 1][x1];
                mins.add(map[i][x1]);
            }

            for (int i = x1; i < x2; i++) {
                map[y2][i] = map[y2][i + 1];
                mins.add(map[y2][i]);
            }

            for (int i = y2; i > y1; i--) {
                map[i][x2] = map[i - 1][x2];
                mins.add(map[i][x2]);
            }

            for (int i = x2; i > x1; i--) {
                map[y1][i] = map[y1][i - 1];
                mins.add(map[y1][i]);
            }
            map[y1][x1 + 1] = topleft;
            mins.add(map[y1][x1 + 1]);
            return mins.stream().min(Integer::compareTo).get();
        }


        private void print() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(map[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
