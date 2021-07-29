package programmers.undefined;

public class p43165 {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = solution(numbers, target);
        System.out.println(result);
    }

    public static int solution(int[] numbers, int target) {
        return recursive(numbers, target, 0, 0);
    }

    public static int recursive(int[] numbers, int target, int idx, int cur) {
        if (idx == numbers.length) {
             return cur == target ? 1 : 0;
        }

        return recursive(numbers, target, idx+1, cur + numbers[idx])
                + recursive(numbers, target, idx+1, cur - numbers[idx]);
    }



}
