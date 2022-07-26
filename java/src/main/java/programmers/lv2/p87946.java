package programmers.lv2;

public class p87946 {

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = new int[][]{{80, 20}, {50, 40}, {30, 10}};

        Solution solution = new Solution();
        int res = solution.solution(k, dungeons);
        System.out.println(res);
    }

    static class Solution {

        private int ans = -1;
        public int solution(int k, int[][] dungeons) {
            boolean[] visited = new boolean[dungeons.length];
            recursive(k, dungeons, visited);
            return ans;
        }

        private void recursive(int k, int[][] dungeons, boolean[] visited) {

            for (int i = 0; i < dungeons.length; i++) {
                int minimum = dungeons[i][0];
                if (visited[i] || minimum > k)
                    continue;
                int usage = dungeons[i][1];
                visited[i] = true;
                recursive(k - usage, dungeons, visited);
                visited[i] = false;
            }

            count_visited(visited);
        }

        private void count_visited(boolean[] visited) {
            int cnt = 0;
            for (boolean b : visited) {
                if (b)
                    cnt++;
            }
            this.ans = Math.max(cnt, ans);
        }
    }
}
