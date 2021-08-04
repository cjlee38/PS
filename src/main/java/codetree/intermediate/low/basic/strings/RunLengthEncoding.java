package codetree.intermediate.low.basic.strings;

import java.io.*;
import java.util.StringTokenizer;

public class RunLengthEncoding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String encoded = encode(str);
        bw.write(encoded.length() + "\n");
        bw.write(encoded);


        bw.flush();
        bw.close();
    }

    private static String encode(String str) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char c = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                cnt++;
            } else {
                sb.append("" + c + cnt);
                c = str.charAt(i);
                cnt = 1;
            }
        }
        if (cnt != 0) {
            sb.append("" + c + cnt);
        }
        return sb.toString();
    }

    public static int[] getArray(int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
