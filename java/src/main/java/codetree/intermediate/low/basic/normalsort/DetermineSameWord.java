package codetree.intermediate.low.basic.normalsort;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class DetermineSameWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        Map<Integer, Long> aMap = a.chars()
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        Map<Integer, Long> bMap = b.chars()
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));


        bw.write(aMap.equals(bMap) ? "Yes" : "No");;


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
