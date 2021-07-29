package programmers.lv1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class p17681 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result = solution(n, arr1, arr2);
        for(String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        boolean[][] map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            addToMap(map, decimalToBinary(n, arr1[i]), i);
            addToMap(map, decimalToBinary(n, arr2[i]), i);
        }

        return mapToAnswer(map);
    }

    public static void addToMap(boolean[][] map, String binary, int line) {
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                map[line][i] = true;
            }
        }
    }

    public static String decimalToBinary(int len, int decimal) {
        StringBuilder sb = new StringBuilder();
        String bin = Integer.toBinaryString(decimal);

        while (sb.length() + bin.length() < len) {
            sb.append('0');
        }

        return sb.append(bin).toString();
    }

    public static String[] mapToAnswer(boolean[][] map) {
        int len = map.length;
        String[] answer = new String[len];
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (map[i][j]) sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}
