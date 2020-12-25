package BOJ.clazz.lv2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10828
 * name = 스택
 */

public class bj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
            else if (command.equals("pop")) if (stack.isEmpty()) bw.write("-1\n"); else bw.write(stack.pop() + "\n");
            else if (command.equals("size")) bw.write(stack.size() + "\n");
            else if (command.equals("empty")) if (stack.isEmpty()) bw.write("1\n"); else bw.write("0\n");
            else if (command.equals("top")) if (stack.isEmpty()) bw.write("-1\n"); else bw.write(stack.peek() + "\n");
        }



        bw.flush();
        bw.close();
    }

}
