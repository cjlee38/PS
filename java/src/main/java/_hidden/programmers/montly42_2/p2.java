package _hidden.programmers.montly42_2;

public class p2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        long[] numbers = {1000000000300383L};
        long[] solution = s.solution(numbers);
        for (long l : solution) {
            System.out.println(l);
        }
    }

    static class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                long number = numbers[i];
                long cur = number + 1;
                while (true) {
                    long and = (cur ^ number);
                    if (check(and)) {
                        answer[i] = cur;
                        break;
                    }
                    cur++;
                }
            }
            return answer;
        }

        public boolean check(long val) {
            int cnt = 0;
            String s = Long.toBinaryString(val);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    cnt++;
                if (cnt > 2)
                    return false;
            }
            return true;
        }
    }
}
