package BOJ.undefined;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 - 미세먼지 안녕!
public class bj17144 {

    static Solution17144 init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return new Solution17144(R, C, T, map);
    }

    public static void main(String[] args) throws IOException {
        Solution17144 s = init();
        int answer = s.run();
        System.out.println(answer);
    }
}

class Solution17144 {
    final private int R;
    final private int C;
    final private int T;

    private int[][] map;

    public Solution17144(int R, int C, int T, int[][] map) {
        this.R = R;
        this.C = C;
        this.T = T;
        this.map = map;
    }

    public int run() {
        int answer = 0;
        AirCleaner posA = findClenaerPos(0);
        AirCleaner posB = findClenaerPos(1);

        for (int i=0; i<T; i++) {
            dustSpread();
            posA.clean(map);
            posB.clean(map);
        }

        answer = getResult();

        return answer;
    }

    private AirCleaner findClenaerPos(int number) {
        AirCleaner AC = null;
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j] == -1) {
                    if (number == 0) {
                        AC = new AirCleaner(i, j, AirCleaner.CLOCKWISE);
                    } else {
                        AC = new AirCleaner(i+1, j, AirCleaner.COUNTER_CLOCKWISE);
                    }
                    return AC;
                }
            }
        }

        return AC;
    }

    private void dustSpread() {
        int[][] newMap = createEmptyMap();
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j] != 0 && map[i][j] != -1) {
                    spread(newMap, i, j, map[i][j]);
                }
            }
        }

        addMap(newMap);
    }

    private void spread(int[][] newMap, int i, int j, int target) {
        int spreadCount = 0;
        if (i != 0 && !isCleaner(i-1, j)) {
            newMap[i-1][j] += target / 5;
            spreadCount++;
        }
        if (i != R-1 && !isCleaner(i+1, j)) {
            newMap[i+1][j] += target / 5;
            spreadCount++;
        }
        if (j != 0 && !isCleaner(i, j-1)) {
            newMap[i][j-1] += target / 5;
            spreadCount++;
        }
        if (j != C-1 && !isCleaner(i, j+1)) {
            newMap[i][j+1] += target / 5;
            spreadCount++;
        }

        newMap[i][j] -= ((target / 5) * spreadCount);
    }

    private int[][] createEmptyMap() {
        int[][] newMap = new int[R][C];
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                newMap[i][j] = 0;
            }
        }

        return newMap;
    }

    private boolean isCleaner(int i, int j) {
        if (map[i][j] == -1) {
            return true;
        } else {
            return false;
        }
    }

    private void addMap(int[][] newMap) {
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                map[i][j] += newMap[i][j];
            }
        }
    }

    public int getResult() {
        int result = 0;
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j] ==-1) {
                    continue;
                } else {
                    result += map[i][j];
                }
            }
        }

        return result;
    }

}

class AirCleaner {
    final static int CLOCKWISE = 0;
    final static int COUNTER_CLOCKWISE = 1;


    final private int X;
    final private int Y;
    final private int clockwise;
    public AirCleaner(int x, int y, int clockwise) {
        X = x;
        Y = y;
        this.clockwise = clockwise;
    }

    public void clean(int[][] map) {
        int x = X;
        int y = Y+1;
        int R = map.length;
        int C = map[0].length;
        int cur;
        int prev = map[x][y-1];

        // go right
        for ( ; y<C-1; y++) {
            cur = map[x][y];
            map[x][y] = map[x][y-1] == -1 ? 0 : prev;
            prev = cur;
        }

        // go up or down
        if (clockwise == CLOCKWISE) {
            for ( ; x<R-1; x++) {
                cur = map[x][y];
                map[x][y] = prev;
                prev = cur;
            }
        } else {
            for ( ; x>0; x--) {
                cur = map[x][y];
                map[x][y] = prev;
                prev = cur;
            }
        }

        // go left
        for ( ; y>0; y--) {
            cur = map[x][y];
            map[x][y] = prev;
            prev =cur;
        }

        // go up or down
        if (clockwise == CLOCKWISE) {
            for ( ; x>X ; x--) {
                cur = map[x][y];
                map[x][y] = prev;
                prev = cur;
            }
        } else {
            for ( ; x<X ; x++) {
                cur = map[x][y];
                map[x][y] = prev;
                prev = cur;
            }
        }
    }
}