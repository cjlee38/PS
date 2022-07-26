package programmers.lv3;

public class p1832 {
    static int MOD = 20170805;
    public static void main(String[] args) {
        int m = 3;
        int n = 6;
        int[][] cityMap = {
                {0, 2, 0, 0, 0, 2},
                {0, 0, 2, 0, 1, 0},
                {1, 0, 0, 2, 2, 0}
        };

        int result = solution(m, n, cityMap);
        System.out.println(result);
    }

    public static int solution(int m, int n, int[][] cityMap) {
        int[][][] map = init(m, n);
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (cityMap[i-1][j-1] == 1) {
                    map[i][j][0] = map[i][j][1] = 0;
                } else if (cityMap[i-1][j-1] == 2) {
                    map[i][j][0] = map[i-1][j][0];
                    map[i][j][1] = map[i][j-1][1];
                } else {
                    map[i][j][0] += (map[i-1][j][0] + map[i-1][j][1]) % MOD;
                    map[i][j][1] += (map[i][j-1][0] + map[i][j-1][1]) % MOD;
                }
            }
        }

        //print
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(cityMap[i][j]);
            }
            System.out.println();
        }

        return cityMap[m-1][n-1] % MOD;

    }

    public static int[][][] init(int m, int n) {
        int[][][] map = new int[m+1][n+1][2];
        map[1][1][0] = map[1][1][1] = 1;

        return map;
    }
}
