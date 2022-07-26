package programmers.lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class p1845 {
    public static void main(String[] args) {
//        int[] nums = {3, 3, 3, 2, 2, 4};
        int[] nums = {3, 1, 2, 3};
        int result = solution(nums);
        System.out.println(result);
    }

    public static int solution(int[] nums) {
        int pick = nums.length / 2;
        Set<Integer> set = generateSet(nums);

        return set.size() >= pick ? pick : set.size();
    }

    public static Set<Integer> generateSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }
}
