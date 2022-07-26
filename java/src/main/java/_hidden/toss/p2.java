package _hidden.toss;

import java.util.Arrays;

public class p2 {
    public static void main(String[] args) {
        int[] prices_1 = {100000, 1, 100000};
//        long[] prices_1 = {78000, 48000, 27000, 285000, 320000, 335100};
        int[] prices_2 = {34000,78000, 48000, 27000, 11000, 285000, 320000, 335100};

        Solution s = new Solution();
        int[] a = s.solution(prices_1);
        int[] b = s.solution(prices_2);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }

    static class Solution {
        public int[] solution(int[] param0) {
            int[] answer = new int[param0.length];
            for (int i = 0; i < param0.length; i++) {
                Asset asset = new Asset();
                answer[i] = timeflies(asset, i, param0);
            }
            return answer;
        }

        private int timeflies(Asset asset, int start, int[] prices) {
            int day = -1;
            asset.buy(prices[start]);
            for (int i = start + 1; i < prices.length; i++) {
                if (asset.isLowerThanHalf(prices[i])) asset.borrowAndBuy(prices[i]);
                else if (asset.isTenTimesProfit(prices[i])) {
                    day = i - start;
                    break;
                }
            }
            return day;
        }

        static class Asset {

            private static final long BUDGET = 100_000_000;
            private long capital;
            private boolean debt;
            private Stock stock;

            public void buy(long price) {
                this.stock = new Stock(price, BUDGET / price);
                capital = BUDGET - (stock.amount * price);
            }

            public boolean isLowerThanHalf(long price) {
                return price <= stock.price / 2;
            }

            public void borrowAndBuy(long price) {
                if (debt) return;
                debt = true;
                capital += 50_000_000;
                stock.amount += capital / price;
            }

            public boolean isTenTimesProfit(long price) {
                long cri = debt ? (BUDGET * 10) + (BUDGET / 2) : BUDGET * 10;
                return stock.amount * price >= cri;
            }
        }

        static class Stock {
            private long price;
            private long amount;

            public Stock(long price, long amount) {
                this.price = price;
                this.amount = amount;
            }
        }
    }
}
