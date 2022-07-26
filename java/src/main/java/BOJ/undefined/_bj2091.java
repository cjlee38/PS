package BOJ.undefined;

import java.io.IOException;
import java.util.*;

public class _bj2091 {
    static Solution2091 init() throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] coins = new int[4];
        int money = sc.nextInt();

        for (int i=0; i<coins.length; i++) {
            coins[i] = sc.nextInt();
        }

        return new Solution2091(money, coins);
    }

    public static void main(String[] args) throws IOException {
        Solution2091 solution = init();
        int[] result = solution.run();
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}

class Solution2091 {
    private int money;
    private Map<Integer, Integer> coins;

    public Solution2091(int money, int[] coins) {
        this.money = money;
        this.coins = initCoins(coins);
    }



    public Map<Integer, Integer> initCoins(int[] coins) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, coins[0]);
        map.put(5, coins[1]);
        map.put(10, coins[2]);
        map.put(25, coins[3]);

        return map;
    }

    public int[] run() {
        int[] numOfCoins = new int[4];
        int[] faceOfCoins = new int[] {1, 5, 10, 25};
        if(!isPossible()) {
            return numOfCoins;
        }

        for (int i = 1; i<faceOfCoins.length; i++) {
            int nextCoin = faceOfCoins[i];
            numOfCoins[i-1] = getNumOfCoin(nextCoin);
        }

        return numOfCoins;
    }

    public boolean isPossible() {
        return coins.entrySet()
                .stream()
                .map(k -> k.getKey() * k.getValue())
                .mapToInt(Integer::intValue)
                .sum() < money;
    }

    public int getNumOfCoin(int nextCoin) {
        int sumofNextCoin = nextCoin * coins.get(nextCoin);
        int count;



        return 0;
    }

}