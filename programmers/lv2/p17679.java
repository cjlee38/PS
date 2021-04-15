package programmers.lv2;

// 프로그래머스 - [1차] 프렌즈4블록
public class p17679 {
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        p17679 p = new p17679();
        int result = p.solution(m, n, board);
        System.out.println(result);

    }

    public int solution(int m, int n, String[] board) {
        String[][] map = splitBoard(board, m, n);

        int sum = 0;
        while (true) {
            int removeCount = removeBlock(map, m, n);
            if (removeCount == 0) break;

            dropBlock(map, m, n);
            sum += removeCount;
        }

        return sum;
    }

    public String[][] splitBoard(String[] board, int m, int n) {
        String[][] map = new String[m][n];

        for (int i = 0; i < m; i++) {
            String[] splited = board[i].split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = splited[j];
            }
        }

        return map;
    }

    public int removeBlock(String[][] map, int m, int n) {
        boolean[][] targetMap = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                selectTarget(map, targetMap, i, j);
            }
        }

        return removeTarget(map, targetMap, m, n);
    }

    public void selectTarget(String[][] map, boolean[][] targetMap, int r, int c) {
        String cur = map[r][c];
        if (r == map.length - 1 || c == map[0].length - 1 || cur.equals(""))
            return;

        if (cur.equals(map[r + 1][c]) && cur.equals(map[r][c + 1]) && cur.equals(map[r + 1][c + 1])) {
            targetMap[r][c] = true;
            targetMap[r + 1][c] = true;
            targetMap[r][c + 1] = true;
            targetMap[r + 1][c + 1] = true;
        }

    }

    public int removeTarget(String[][] map, boolean[][] targetMap, int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (targetMap[i][j]) {
                    map[i][j] = "";
                    count++;
                }
            }
        }

        return count;
    }

    public void dropBlock(String[][] map, int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                String cur = map[i][j];
                if (cur.equals("")) drawBlock(map, i, j);
            }
        }
    }

    public void drawBlock(String[][] map, int r, int c) {
        int i = r, j = c;
        while(i >= 0 && map[i][j].equals("")) i--;

        if (i == -1) return;

        map[r][c] = map[i][j];
        map[i][j] = "";

    }

    public void print(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}


