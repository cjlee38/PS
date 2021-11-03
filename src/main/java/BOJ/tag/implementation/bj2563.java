package BOJ.tag.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2563
 * name = 색종이
 * tier = silver 5
 * date = 2021-10-27, 수, 23:9
 */

public class bj2563 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            int num = bInt(br);
            List<ColorPaper> colorPaperList = new ArrayList<>();
            while (num-- > 0) {
                StringTokenizer st = tokenize(br);
                colorPaperList.add(new ColorPaper(sInt(st), sInt(st)));
            }

            Solution s = new Solution(colorPaperList);
            int run = s.run();
            bw.write(run + "");

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

    static class ColorPaper {
        public static final int SIZE = 10;

        private int leftPadding;
        private int bottomPadding;

        public ColorPaper(int leftPadding, int bottomPadding) {
            this.leftPadding = leftPadding;
            this.bottomPadding = bottomPadding;
        }
    }

    static class Solution {
        private static final int SIZE = 100;
        private boolean[][] board = new boolean[SIZE][SIZE];

        private List<ColorPaper> colorPaperList;

        public Solution(List<ColorPaper> colorPaperList) {
            this.colorPaperList = colorPaperList;
        }

        public int run() {
            for (ColorPaper colorPaper : colorPaperList) {
                attach(colorPaper);
            }
            return measureCoveredArea();
        }

        private int measureCoveredArea() {
            int count = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (this.board[i][j]) count++;
                }
            }
            return count;
        }

        private void attach(ColorPaper colorPaper) {
            int x = colorPaper.leftPadding;
            int y = colorPaper.bottomPadding;

            for (int i = y; i < y + ColorPaper.SIZE; i++) {
                for (int j = x; j < x + ColorPaper.SIZE; j++) {
                    this.board[i][j] = true;
                }
            }
        }

    } // end of class
}

