package programmers.lv2;

public class p68645 {
    public static void main(String[] args) {
        int n = 4;
        int[] result = solution(n);
        for(int i=0; i< result.length;i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(final int n) {
        final int[][] map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = new int[i + 1];
        }
        int direction = 0;
        int value = 0;
        int x = -1;
        int y = 0;
        int forward = n;
        for (int i = 0; i < n; i++) {
            final int curDir = direction % 3;
            for (int j = 0; j < forward; j++) {
                value++;
                if (curDir == 0) {
                    map[++x][y] = value;
                } else if (curDir == 1) {
                    map[x][++y] = value;
                } else {
                    map[--x][--y] = value;
                }
            }
            forward--;
            direction++;
        } // end of outside

        final int[] answer = new int[getCount(n)];
        int idx = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                answer[idx++] = map[i][j];
            }
        }

        return answer;
    } // end of function

    public static int getCount(final int n) {
        int value = 0;
        for(int i=n; i>0; i--) {
            value += i;
        }
        return value;
    }
}
