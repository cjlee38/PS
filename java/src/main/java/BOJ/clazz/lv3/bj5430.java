package BOJ.clazz.lv3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * uri = https://www.acmicpc.net/problem/5430
 * name = AC
 * tier = silver 2
 */

public class bj5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int m = Integer.parseInt(br.readLine());
            Deque<Integer> D = new ArrayDeque<>();
            String[] split = br.readLine().replace("[", "").replace("]", "").split(",");
            for (int i = 0; i < m; i++) {
                D.add(Integer.parseInt(split[i]));
            }

            Solution s = new Solution(commands, D);
            bw.write(s.run() + "\n");
        }


        bw.flush();
        bw.close();
    }

    static class Solution {

        private static final char REVERSE = 'R';
        private static final char DELETE = 'D';

        private char[] commands;
        private Deque<Integer> D;

        public Solution(char[] commands, Deque<Integer> d) {
            this.commands = commands;
            D = d;
        }

        public String run() {
            boolean forward = true;

            for (char command : commands) {
                if (command == REVERSE) {
                    forward = !forward;
                } else if (!D.isEmpty()) {
                    if (forward) D.removeFirst();
                    else D.removeLast();
                } else {
                    return "error";
                }
            }

            return print(forward);
        }

        private String print(boolean forward) {
            if (D.isEmpty()) return "[]";

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            while (!D.isEmpty()) {
                if (forward) sb.append(D.pollFirst());
                else sb.append(D.pollLast());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");

            return sb.toString();
        }

    } // end of class
}
