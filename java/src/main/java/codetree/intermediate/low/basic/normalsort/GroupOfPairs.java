package codetree.intermediate.low.basic.normalsort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GroupOfPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = getArray(2 * n, br);

        Arrays.sort(arr);
        int max = -1;
        for (int i = 0; i < n; i++)
            max = Math.max(max, arr[i] + arr[arr.length - i - 1]);

        bw.write(max + "");

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
