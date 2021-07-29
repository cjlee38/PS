package programmers.lv2;


/**
 * uri = https://programmers.co.kr/learn/courses/30/lessons/77885
 * name = 2개 이하로 다른 비트
 */
public class p77885 {
    public static void main(String[] args) {
        long[] numbers = new long[]{2L, 7L};
        Solution s = new Solution();
        long[] result = s.solution(numbers);
    }
    static class Solution {
        public long[] solution(long[] numbers) {
            int len = numbers.length;
            long[] answer = new long[len];

            b :
            for (int i = 0; i < len; i++) {
                long number = numbers[i];
                if (number % 2 == 0)
                    answer[i] = number + 1;
                else {
                    StringBuilder sbNumber = new StringBuilder(Long.toBinaryString(number));
                    for (int j = sbNumber.length() - 1; j >= 0; j--) {
                        if (sbNumber.charAt(j) == '0') {
                            sbNumber.setCharAt(j, '1');
                            sbNumber.setCharAt(j + 1, '0');
                            answer[i] = Long.parseLong(sbNumber.toString(), 2);
                            continue b;
                        }
                    }
                    sbNumber.setCharAt(0, '0');
                    sbNumber.insert(0, '1');
                    answer[i] = Long.parseLong(sbNumber.toString(), 2);
                }
            }
            return answer;
        }


    }
}
