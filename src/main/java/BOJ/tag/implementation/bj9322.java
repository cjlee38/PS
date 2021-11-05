package BOJ.tag.implementation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/9322
 * name = 철벽 보안 알고리즘
 * tier = silver 3
 * date = 2021-11-5, 금, 23:13
 */

public class bj9322 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //

            int T = bInt(br);
            while (T-- > 0) {
                int n = bInt(br);
                String[][] strings = new String[3][n];
                for (int i = 0; i < 3; i++) {
                    StringTokenizer st = tokenize(br);
                    for (int j = 0; j < n; j++) {
                        strings[i][j] = st.nextToken();
                    }
                }
                Solution s = new Solution(strings);
                String[] res = s.run();
                bw.write(String.join(" ", res));
                bw.write("\n");
            }


            // == done == //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static StringTokenizer tokenize(BufferedReader br) throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static int bInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int sInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private String[] first;
        private String[] second;
        private String[] encoded;

        public Solution(String[][] input) {
            this.first = input[0];
            this.second = input[1];
            this.encoded = input[2];
        }

        public String[] run() {
            String[] origin = new String[encoded.length];
            Map<String, Integer> fromMap = new HashMap<>();
            for (int i = 0; i < second.length; i++) {
                fromMap.put(second[i], i);
            }
            for (int i = 0; i < first.length; i++) {
                int start = i;
                int end = fromMap.get(first[i]);
                origin[i] = encoded[end];
            }
            return origin;
        }

    } // end of class
}

