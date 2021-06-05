package programmers.lv3;

import java.util.*;

public class p77486 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] ans = sol.solution(enroll, referral, seller, amount);
        for (int an : ans) {
            System.out.print(an + " ");
        }

    }


    static class Solution {
        static final int TOOTHBRUSH_PRICE = 100;
        static final double TAX = 0.1;

        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            Map<String, String> parentMap = new HashMap<>(); // child & parent
            Map<String, Integer> profitMap = new HashMap<>(); // child & profit

            parentMap.put("-", null);
            profitMap.put("-", 0);
            for (int i = 0; i < enroll.length; i++) {
                parentMap.put(enroll[i], referral[i]);
                profitMap.put(enroll[i], 0);
            }

            for (int i = 0; i < seller.length; i++) {
                String child = seller[i];
                int profit = amount[i] * TOOTHBRUSH_PRICE;
                profitMap.put(child, profitMap.get(child) + profit);

                while (parentMap.get(child) != null && profit >= 1) {
                    String parent = parentMap.get(child);
                    int parentProfit = (int) (profit * TAX);

                    profitMap.put(child, profitMap.get(child) - parentProfit);
                    profitMap.put(parent, profitMap.get(parent) + parentProfit);

                    child = parent;
                    profit = parentProfit;
                }
            }

            int[] answer = Arrays.stream(enroll).mapToInt(profitMap::get).toArray();
            return answer;
        }

    }

}
