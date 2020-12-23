package BOJ.undefined;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10227 {

    static Solution10227 init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return new Solution10227(r, c, h, w, map);
    }

    public static void main(String[] args) throws IOException {
        Solution10227 s = init();
        int answer = s.run();
        System.out.println(answer);
    }
}

class Solution10227 {
    private int R;
    private int C;
    private int H;
    private int W;
    private int[][] map;

    public Solution10227(int r, int c, int h, int w, int[][] map) {
        R = r;
        C = c;
        H = h;
        W = w;
        this.map = map;
    }

    public int run() {
        int min = 1;
        int max = R * C;
        int mid;

        while (true) {
            mid = (max + min) / 2;
            int result = tryMedian(mid);

            if (result == 0) break;
            else if (result == 1) min = mid + 1;
            else max = mid - 1;
        }
        return mid;
    }

    private int tryMedian(int mid) {
        boolean exists = false;

        int[] rowSum = new int[R];
        for (int i = 0; i <= C - W; i++) {
            getRowSumOfTernary(rowSum, mid, i);
            int mapSum = 0;
            for (int j = 0; j <= R - H; j++) {
                mapSum += getMapSum(rowSum, j);

                if (mapSum == 0) exists = true;
                else if (mapSum < 0) return -1;
            }
        }

        if (exists) return 0;
        return 1;
    }


    private void getRowSumOfTernary(int[] rowSum, int mid, int x) {
        if (x == 0) {
            for (int i = 0; i < R; i++) {
                int sum = 0;
                for (int j = x; j < x + W; j++) {
                    sum += getTernary(mid, map[i][j]);
                }
                rowSum[i] = sum;
            }
        } else {
            for (int i = 0; i < R; i++) {
                rowSum[i] += getTernary(mid, map[i][x+W-1])- getTernary(mid, map[i][x-1]);
            }
        }
    }

    private int getTernary(int mid, int value) {
        if (value == mid) return 0;
        else if (value > mid) return 1;
        else return -1;
    }

    private int getMapSum(int[] rowSum, int x) {
        int mapSum = 0;
        if (x == 0) {
            for (int i = 0; i < H; i++) {
                mapSum += rowSum[i];
            }
        } else {
            mapSum += rowSum[x+H-1] - rowSum[x-1];
        }

        return mapSum;
    }
}
