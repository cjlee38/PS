package BOJ.clazz.lv4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2263
 * name = 트리의 순회
 * tier = gold3
 * date = 2021-07-3, 토, 11:6
 */

public class bj2263 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] inOrder = new int[n];
        int[] postOrder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = pInt(st);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = pInt(st);
        }

        Solution s = new Solution(n, inOrder, postOrder);
        s.run();
//        for (int i = 0; i < n; i++)
//            bw.write(res[i] + " ");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private int n;
        private int[] inOrder;
        private int[] postOrder;

        public Solution(int n, int[] inOrder, int[] postOrder) {
            this.n = n;
            this.inOrder = inOrder;
            this.postOrder = postOrder;
        }

        public void run() {
            int root = postOrder[n - 1];
            int index = -1;
            for (int i = 0; i < n; i++)
                if (inOrder[i] == root)
                    index = i;
            print(inOrder[index]);
            recursive(0, index - 1);
            recursive(index + 1, n - 1);

        }

        public void recursive(int left, int right) {
            if (left < 0 || right >= n)
                return ;
            if (left == right) {
                print(inOrder[left]);
                return ;
            }
            int mid = (left + right + 1) / 2;
            recursive(left, mid - 1);
            print(inOrder[mid]);
            recursive(mid + 1, right);

        }

        public void print(int num) {
            System.out.print(num + " ");
        }

    } // end of class
}

