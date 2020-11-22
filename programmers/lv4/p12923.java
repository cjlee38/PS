package programmers.lv4;

public class p12923 {
    public static void main(String[] args) {
        long begin = 990000000;
        long end = 990000010;

        p12923 p = new p12923();
        int[] answer = p.solution(begin, end);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(long begin, long end) {
        int n = (int) (end - begin + 1);
        int[] road = new int[n];

        for (int i = 0; i < n; i++) {
            long cur = i + begin;
            road[i] = getGCD(cur);
        }

        if (begin == 1) road[0] = 0;
        return road;
    }

    private int getGCD(long cur) {
        for (long i = 2; i <= Math.sqrt(cur); i++) {
            if (cur / i > 10000000) continue;
            if (cur % i == 0) return (int) (cur / i);
        }

        return 1;
    }

}
