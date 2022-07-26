package BOJ.clazz.lv3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/16928
 * name = 뱀과 사다리 게임
 * tier = silver 1
 */

public class bj16928 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] board = new int[100 + 1];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Solution s = new Solution(board);
        int run = s.run();
        bw.write(run + "");
        bw.flush();
        bw.close();
    }

    static class Solution {

        private static final int[] DICE = new int[]{1, 2, 3, 4, 5, 6};
        private int[] board;

        public Solution(int[] board) {
            this.board = board;
        }

        public int run() {
            int count = 0;
            boolean[] visited = new boolean[board.length];
            Queue<Player> Q = new LinkedList<>();

            Q.offer(new Player(1, 0));
            visited[0] = true;
            while (!Q.isEmpty()) {
                Player poll = Q.poll();
                if (poll.getPosition() == 100) return poll.count;
                for (int dice : DICE) {
                    int next = move(poll.getPosition() + dice);
                    if (next != -1 && !visited[next]) {
                        visited[next] = true;
                        Q.offer(new Player(next, poll.getCount() + 1));
                    }
                }

            }

            return 0;
        }


        private int move(int pos) {

            if (pos > 100)
                return -1;
            return board[pos] == 0 ? pos : board[pos];
        }

    } // end of class

    static class Player {
        private int position;
        private int count;

        public Player(int position, int count) {
            this.position = position;
            this.count = count;
        }

        public int getPosition() {
            return position;
        }

        public int getCount() {
            return count;
        }
    }
}
