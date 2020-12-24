package BOJ.clazz.lv2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * uri =  https://www.acmicpc.net/problem/1874
 * name = 스택 수열
 */

public class bj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Solution s = new Solution(arr);
        String[] result = s.run();

        for(int i = 0; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static class Solution {
        private int[] arr;

        public Solution(int[] arr) {
            this.arr = arr;
        }

        public String[] run() {
            boolean flag = false;
            int n = arr.length;
            int j = 0;
            Stack<Integer> stack = new Stack<>();
            List<String> list = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                stack.push(i);
                list.add("+");

                while (!stack.isEmpty() && stack.peek() == arr[j]) {
                    stack.pop();
                    list.add("-");
                    j++;
                }
            }

            if(!stack.isEmpty()) return new String[]{"NO"};
            else return list.toArray(String[]::new);
        }
    }
}
