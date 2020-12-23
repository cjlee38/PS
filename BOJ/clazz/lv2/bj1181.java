package BOJ.clazz.lv2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1181
 * name = 단어 정렬
 */

public class bj1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.stream(words)
                .distinct()
                .sorted(((o1, o2) -> {
                    if (o1.length() == o2.length()) return o1.compareTo(o2);
                    else return o1.length() - o2.length();
                })).forEach(x -> {
            try {
                bw.write(x + "\n");
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        bw.close();
    }

}
