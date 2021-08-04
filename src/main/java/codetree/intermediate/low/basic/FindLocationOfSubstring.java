package codetree.intermediate.low.basic;

import java.io.*;
import java.util.StringTokenizer;

public class FindLocationOfSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String sub = br.readLine();
        int idx = -1;

        for (int i = 0; i < str.length() - sub.length() + 1; i++) {
            if (isMatch(str, sub, i)) {
                idx = i;
                break ;
            }
        }
        bw.write(idx + "");

        bw.flush();
        bw.close();
    }

    private static boolean isMatch(String str, String sub, int idx) {
        for (int i = 0; i < sub.length(); i++) {
            if (idx > str.length() - 1) break ;
            if (str.charAt(idx) != sub.charAt(i)) return false;
            ++idx;
        }
        return true;
    }

    public static int[] getArray(int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
