package codetree.intermediate.low.basic.minmax;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaxProfitOfSingleCar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int profit = 0;
        int[] arr = getArray(n, br);
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i : arr) {
            if (stack.peek() < i)
                profit = Math.max(profit, i - stack.peek());
            else
                stack.push(i);
        }
        bw.write(profit + "");

        bw.flush();
        bw.close();
    }

    public static int[] getArray(int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
