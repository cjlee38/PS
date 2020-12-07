package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 게임판 덮기

/*
3
3 7
#.....#
#.....#
##...##
3 7
#.....#
#.....#
##..###
8 10
##########
#........#
#........#
#........#
#........#
#........#
#........#
##########

0
2
1514

 */

public class Boardcover {
    public static void main(String[] args) throws IOException {
        List<Solution> solutions = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int[][] board = new int[h][w];

            for (int j = 0; j < h; j++) {
                board[j] = br.readLine().chars().map(x -> x == '#' ? 1 : 0).toArray();
            }
            solutions.add(new Solution(h, w, board));
        }


        for (Solution solution : solutions) {
            int result = solution.run();
            System.out.println(result);
        }
    }

    static class Solution {
        private int h;
        private int w;
        private int[][] board;

        private int ret = 0;
        private static int[][][] coverType = {
                {{0, 0}, {1, 0}, {0, 1}}, //┌
                {{0, 0}, {0, 1}, {1, 1}}, // ┐
                {{0, 0}, {1, 0}, {1, 1}}, //└
                {{0, 0}, {1, 0}, {1, -1}} // ┘
        };


        // {{0, 1}, {1, 1}}
        public Solution(int h, int w, int[][] board) {
            this.h = h;
            this.w = w;
            this.board = board;
        }

        public int run() {
            return cover(board);
        }

        private boolean set(int[][] board, int y, int x, int type, int stack) {

            boolean ok = true;

            for (int i = 0; i < 3; i++) {
                int ny = y + coverType[type][i][0];
                int nx = x + coverType[type][i][1];

                if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) {
                    ok = false;
                } else if ((board[ny][nx] += stack) > 1) {
                    ok = false;
                }
            }
            return ok;
        }

        private int cover(int[][] board) {

            int y = -1, x = -1;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) {
                        y = i;
                        x = j;
                        break;
                    }
                } // end of for j
                if (y != -1) {
                    break;
                }
            } // end of for i

            if (y == -1) {
                return 1;
            }

            int result = 0;

            for (int type = 0; type < 4; type++) {
                if (set(board, y, x, type, 1)) {
                    result += cover(board);
                }
                set(board, y, x, type, -1);
            } // end of for type
            return result;
        }
    }
}
/*
public class Boardcover {
    public static void main(String[] args) throws IOException {
        List<Solution> solutions = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            String[][] board = new String[h][w];

            for (int j = 0; j < h; j++) {
                board[j] = br.readLine().split("");
            }
            solutions.add(new Solution(h, w, board));
        }


        for (Solution solution : solutions) {
            int result = solution.run();
            System.out.println(result);
        }


    }

//             for (int a = 0 ; a < h; a++ ) {
//                for (int b = 0; b < w; b++) {
//                    System.out.print(board[a][b]);
//                }
//                System.out.println();
//            }

    static class Solution {
        int h;
        int w;
        String[][] board;

        int ret = 0;
        int[][][] blocks = new int[][][]{
                {{0, 1}, {1, 1}},
                {{1, 0}, {1, 1}},
                {{1, 1}, {0, 1}},
                {{1, 1}, {1, 0}}
        };

        // {{0, 1}, {1, 1}}
        public Solution(int h, int w, String[][] board) {
            this.h = h;
            this.w = w;
            this.board = board;
        }

        public int run() {
            int empty = countEmpty();
            if (empty % 3 != 0) return 0;

            recursive(0, 0, empty);

            return ret;
        }


        private void print() {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        private void recursive(int x, int y, int empty) {
            print();
            if (empty == 0) {
                ret++;
                return;
            }

            boolean breaker = stop();

            for (int i = y; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    for (int k = 0; k < blocks.length; k++) {
                        if (isCoverable(j, i, k)) {
                            set(j, i, k, true);
                            recursive(j, i, empty - 3);
                            set(j, i, k, false);
                        }
                    }
                }
            }
        }

        public boolean stop() {
            boolean flag = true;
            String[] arr = new String[3];
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board[i].length; j++) {
                    sb.append(board[i][j]);
                }

                String str = sb.toString();
                arr[i] = str;
            }

            if (arr[0].equals("#######") && arr[1].equals("##.####") && arr[2].equals("##..###")) {
                return true;
            }

            return false;



        }

        public void set(int x, int y, int n, boolean isCover) {
            int[][] curBlock = blocks[n];

            for (int i = 0; i < curBlock.length; i++) {
                for (int j = 0; j < curBlock[i].length; j++) {
                    if (curBlock[i][j] == 1)
                        board[y + i][x + j] = isCover ? "#" : ".";
                }
            }
        }

        public boolean isCoverable(int x, int y, int k) {
            return !isOutOfRange(x, y) && isBlockFit(x, y, k);

        }

        public boolean isOutOfRange(int x, int y) {
            return (x + 1 >= w) || (y + 1 >= h);
        }

        public boolean isBlockFit(int x, int y, int k) {
            int[][] curBlock = blocks[k];
            for (int i = 0; i < curBlock.length; i++) {
                for (int j = 0; j < curBlock[i].length; j++) {
                    if (curBlock[i][j] == 1 && board[y + i][x + j].equals("#"))
                        return false;
                }
            }

            return true;
        }

        public boolean isWhite(String s) {
            return s.equals(".");
        }


        public int countEmpty() {
            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (isWhite(board[i][j]))
                        count++;
                }
            }

            return count;
        }
    }
}


 */