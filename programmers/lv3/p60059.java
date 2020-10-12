package programmers.lv3;

public class p60059 {
    final static private int TURN_LIMIT = 4;
    public static void main(String[] args) {
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1},
        };

        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},
        };

        boolean result = solution(key, lock);
        System.out.println(result);
    }
    public static boolean solution(int[][] key, int[][] lock) {
        for(int i=0; i<TURN_LIMIT; i++) {
            key = rotate(key);
            if (isUnlocked(key, lock)) return true;
        }

        return false;
    }

    private static int[][] rotate(int[][] key) {
        int len = key.length;
        int[][] newKey = new int[len][len];

        for (int i=len-1; i>=0; i--) {
            for (int j=0; j<len; j++) {
                newKey[len-i -1][j] = key[j][i];
            }
        }

        return newKey;
    }

    private static boolean isUnlocked(int[][] key, int[][] lock) {
        int len = key.length;

        for(int cur=1; cur<=len; cur++) {
            int[][] piece = getKeyPiece(key, cur);
            if (isMatch(piece, lock)) return true;

        }

        return false;
    }

    private static int[][] getKeyPiece(int[][] key, int cur) {
        int[][] piece = new int[cur][cur];
        for (int i=0; i<cur; i++) {
            for (int j=0; j<cur; j++) {
                piece[i][j] = key[i][j];
            }
        }

        return piece;
    }

    private static boolean isMatch(int[][] piece, int[][] lock) {
        int padding = piece.length-1;
        int[][] paddingLock = getPaddingLock(padding, lock);
        int[] pos = new int[2];

        for (int i=0; i<paddingLock.length - padding; i++) {
            for (int j=0; j<paddingLock.length - padding; j++) {
                paddingLock = getPaddingLock(padding, lock);
                pos[0] = i;
                pos[1] = j;
                if(isSuccess(piece, paddingLock, pos, padding)) return true;
            }
        }

        return false;
    }

    private static int[][] getPaddingLock(int padding, int[][] lock) {
        int arrSize = (padding)*2 + lock.length;
        int[][] paddingLock = new int[arrSize][arrSize];

        for (int i=0; i<lock.length; i++) {
            for (int j=0; j<lock.length; j++) {
                paddingLock[i+padding][j+padding] = lock[i][j];
            }
        }

        return paddingLock;
    }

    private static int[][] copy(int[][] arr) {
        int[][] newArr = new int[arr.length][arr.length];
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }

        return newArr;
    }

    private static boolean isSuccess(int[][] key, int[][] paddingLock, int[] pos, int padding) {
        tryUnlock(key, paddingLock, pos);

        for (int i=padding; i<paddingLock.length-padding; i++) {
            for (int j=padding; j<paddingLock.length-padding; j++) {
                if (paddingLock[i][j] != 1) return false;
            }
        }

        return true;
    }

    private static void tryUnlock(int[][] key, int[][] paddingLock, int[] pos) {
        for(int i=0; i<key.length; i++) {
            for (int j=0; j<key.length; j++) {
                paddingLock[i+pos[0]][j+pos[1]] += key[i][j];
            }
        }
    }
}
