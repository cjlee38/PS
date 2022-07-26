package BOJ.tier.gold;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2493
 * name = 탑
 * tier = gold 5
 */

public class bj2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Top> tops = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int curHeight = Integer.parseInt(st.nextToken());
            while(!tops.isEmpty()) {
                if (tops.peek().getHeight() >= curHeight) {
                    ans.append(tops.peek().getIndex() + " ");
                    break;
                }
                tops.pop();
            }

            if (tops.isEmpty()) {
                ans.append("0 ");
            }
            tops.push(new Top(i, curHeight));
        }

        bw.write(ans.toString());

        bw.flush();
        bw.close();
    }

    static class Top {
        private final int index;
        private final int height;

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public int getIndex() {
            return index;
        }

        public int getHeight() {
            return height;
        }
    }
}
