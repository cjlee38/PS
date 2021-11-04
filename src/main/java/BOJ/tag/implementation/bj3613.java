package BOJ.tag.implementation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/3613
 * name = Java vs C++
 * tier = silver 5
 * date = 2021-11-4, 목, 22:36
 */

public class bj3613 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            String str = br.readLine();
            Solution s = new Solution(str);
            String res = s.run();
            bw.write(res);
            bw.flush();


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
        private static final String ERROR = "Error!";
        private String str;

        public Solution(String str) {
            this.str = str;
        }

        public String run() {
            boolean isJava = false;
            boolean isCpp = false;
            if (str.length() == 0 || !(Character.isLowerCase(str.charAt(0))))
                return ERROR;

            for (char c : str.toCharArray()) {
                if (c == '_') {
                    if (isJava) return ERROR;
                    isCpp = true;
                }
                if (Character.isUpperCase(c)) {
                    if (isCpp) return ERROR;
                    isJava = true;
                }
            }
            return isJava ? convertToCpp() : convertToJava();
        }

        private String convertToCpp() {
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (Character.isUpperCase(c)) {
                    sb.append('_');
                }
                sb.append(Character.toLowerCase(c));
            }
            return sb.toString();
        }

        private String convertToJava() {
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '_') {
                    if (i == chars.length - 1) return ERROR;
                    ++i;
                    c = Character.toUpperCase(chars[i]);
                    if (c == '_') return ERROR;
                }
                sb.append(c);
            }
            return sb.toString();
        }

    } // end of class
}

