package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p67256 {

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        String result = solution(numbers, hand);
        System.out.println(result);
    }
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[][] phone = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -2}
        };

        List<Integer> leftNumbers = new ArrayList<>(Arrays.asList(1, 4, 7));
        List<Integer> rightNumbers = new ArrayList<>(Arrays.asList(3, 6, 9));
        Hand left = new Hand(0, 3);
        Hand right = new Hand(2, 3);


        for (int number : numbers) {
            if (leftNumbers.contains(number)) {
                left.pressButton(phone, number);
                sb.append("L");
            } else if (rightNumbers.contains(number)) {
                right.pressButton(phone, number);
                sb.append("R");
            } else {
                int leftDist = left.getDistance(phone, number);
                int rightDist = right.getDistance(phone, number);

                if (leftDist == rightDist) {
                    if (hand.equals("right")) {
                        right.pressButton(phone, number);
                        sb.append("R");
                    } else {
                        left.pressButton(phone, number);
                        sb.append("L");
                    }
                } else if (leftDist < rightDist) {
                    left.pressButton(phone, number);
                    sb.append("L");
                } else {
                    right.pressButton(phone, number);
                    sb.append("R");
                }
            }
        }

        return sb.toString();
    }
}

class Hand {
    private int posX;
    private int posY;

    public Hand(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getDistance(int[][] phone, int number) {
        int distance = 0;
        b: for (int i=0; i< phone.length; i++) {
            for (int j=0; j <phone[0].length; j++) {
                if (phone[i][j] == number) {
                    distance = Math.abs(posY - i) + Math.abs(posX - j);
                    break b;
                }
            }
        }
        return distance;
    }

    public void pressButton(int[][] phone, int number) {
        b: for (int i=0; i< phone.length; i++) {
            for (int j=0; j <phone[0].length; j++) {
                if (phone[i][j] == number) {
                    this.posX = j;
                    this.posY = i;
                    break b;
                }
            }
        }
    }
}
