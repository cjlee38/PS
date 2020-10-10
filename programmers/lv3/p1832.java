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

    }
}
