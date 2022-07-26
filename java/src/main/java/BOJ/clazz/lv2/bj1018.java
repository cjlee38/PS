package BOJ.clazz.lv2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri =http s://www.acmicpc.net/problem/1018
 * name = 체스판 다시 칠하기
 */

public class bj1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] board = new int[h][w];
        for (int i = 0; i < h; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                board[i][j] = chars[j] == 'W' ? 0 : 1; // White = 0, Black = 1
            }
        }

        Solution s = new Solution(h, w, board);
        int result = s.run();
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    static class ChessBoard {
        public static final int[] WHITE_ROW;
        public static final int[] BLACK_ROW;
        public static final int CHESS_SIZE;

        static {
            WHITE_ROW = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
            BLACK_ROW = new int[]{1, 0, 1, 0, 1, 0, 1, 0};
            CHESS_SIZE = 8;
        }
    }

    static class Solution {
        private int h;
        private int w;
        private int[][] board;


        public Solution(int h, int w, int[][] board) {
            this.h = h;
            this.w = w;
            this.board = board;
        }

        public int run() {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i <= h - ChessBoard.CHESS_SIZE; i++) {
                for (int j = 0; j <= w - ChessBoard.CHESS_SIZE; j++) {
                    int count = compare(j, i, true, min);
                    if (count != -1) min = count;

                    count = compare(j, i, false, min);
                    if (count != -1) min = count;
                }
            }

            return min;
        }

        public int compare(int x, int y, boolean isWhite, int min) {
            int count = 0;
            for (int i = y; i < y + ChessBoard.CHESS_SIZE; i++) {
                int[] chessRow = getRow(isWhite);
                for (int j = x; j < x + ChessBoard.CHESS_SIZE; j++) {
                    if (board[i][j] != chessRow[j - x]) count++;
                }
                isWhite = !isWhite;

                if (min < count) return -1;
            }

            return count;
        }

        public int[] getRow(boolean isWhiteRow) {
            if (isWhiteRow) return ChessBoard.WHITE_ROW;
            else return ChessBoard.BLACK_ROW;
        }

        private void print() {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
