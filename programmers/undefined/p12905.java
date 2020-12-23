package programmers.undefined;

// 가장 큰 정사각형 찾기
public class p12905 {

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0},
        };

        int[][] board2 = {
                {0, 0, 1, 1},
                {1, 1, 1, 1}
        };

        int[][] board3 = {
                {1}
        };

        int result = solution(board3);
        System.out.println(result);
    }
    public static int solution(int [][]board) {
        int min;
        int max = 0;
        for (int i= 1; i<board.length; i++) {
            for (int j = 1; j<board[0].length; j++) {
                if (board[i][j] == 1) {
                    min = Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1]));
                    board[i][j] = min+1;
                }
            }
        }

        for (int i= 0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    max = Math.max(max, board[i][j]);
                }
            }
        }
        return max*max;
    }

}
