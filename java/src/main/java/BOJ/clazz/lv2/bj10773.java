package BOJ.clazz.lv2;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10773
 * name = 제로
 */

public class bj10773 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Stack<Integer> st = new Stack<>();
        while(k-- > 0) {
            int n = sc.nextInt();
            if (n == 0) st.pop();
            else st.push(n);
        }

        int sum = st.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

    }
}
