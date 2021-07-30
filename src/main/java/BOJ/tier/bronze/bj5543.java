package BOJ.tier.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/5543
 * name = 상근날드
 * tier = bronze 4
 * date = 2021-07-30, 금, 11:38
 */

public class bj5543 {

    private static final int NUM_BURGERS = 3;
    private static final int NUM_DRINKS = 2;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            int[] burgers = new int[NUM_BURGERS];
            int[] drinks = new int[NUM_DRINKS];
            for (int i = 0; i < NUM_BURGERS; i++) {
                burgers[i] = bInt(br);
            }
            for (int i = 0; i < NUM_DRINKS; i++) {
                drinks[i] = bInt(br);
            }
            int burgerMin = Arrays.stream(burgers).min().getAsInt();
            int drinkMin = Arrays.stream(drinks).min().getAsInt();
            bw.write((burgerMin + drinkMin - 50) + "");
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

        public int run() {

            return -1;
        }

    } // end of class
}

