package BOJ.tier.bronze;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1000
 * name = A + B
 * tier = bronze 5
 * date = 2021-07-30, 금, 0:56
 */

public class bj1000 {

//    private static BufferedReader br;
//    private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) {
        Reader reader; Writer writer;
        if (args.length == 0) {
            reader = new InputStreamReader(System.in);
            writer = new OutputStreamWriter(System.out);
        } else {
            reader = new StringReader(args[0]);
            writer = new StringWriter();
        }
        try(BufferedReader br = new BufferedReader(reader);
            BufferedWriter bw = new BufferedWriter(writer);) {

            st = tokenize(br);
            Solution s = new Solution();
            bw.write(s.run() + "");
//            bw.flush();
        } catch (IOException e) {
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

        public int run() {

            return -1;
        }

    } // end of class
}

