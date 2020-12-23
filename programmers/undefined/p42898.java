package programmers.undefined;

public class p42898 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {
                {2, 2}
        };

        int result = solution(m, n, puddles);
        System.out.println(result);
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] board = init(m, n, puddles);

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                    continue;
                }
                if (i != 0) board[i][j] += board[i-1][j] % 1000000007;
                if (j != 0) board[i][j] += board[i][j-1] % 1000000007;
            }
        }

        return board[n-1][m-1] % 1000000007;
    }

    public static int[][] init(int m, int n, int[][] puddles) {
        int[][] board = new int[n][m];
        board[0][0] = 1;

        for (int[] puddle : puddles) {
            board[puddle[1]-1][puddle[0]-1] = -1;
        }

        return board;
    }
}
