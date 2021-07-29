package programmers.lv3;

public class p12952 {
    int count = 0;

    public static void main(String[] args) {
        int n = 4;

        p12952 p = new p12952();
        int result = p.solution(n);
        System.out.println(result);
    }

    public int solution(int n) {
        for (int i = 0; i < n; i++) {
            int[] cols = new int[n];
            cols[0] = i;
            recursive(n, cols, 1);
        }

        return count;
    }

    public void recursive(int n, int[] cols, int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            cols[row] = i;
            if (isPossible(cols, row)) recursive(n, cols, row+1);
        }
    }

    public boolean isPossible(int[] cols, int row) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == cols[row]) return false;
            if (Math.abs(row - i) == Math.abs(cols[i] - cols[row])) return false;
        }

        return true;
    }


}
