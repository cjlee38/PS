package programmers.undefined;

import java.util.*;

public class p12935 {
    public static void main(String[] args) {
        int[] arr = {10};
        int[] result = solution(arr);
        for(int i : result) {
            System.out.println(i);
        }

    }

    public static int[] solution(int[] arr) {
        int min = Arrays.stream(arr).reduce((x, y) -> x > y ? y : x).getAsInt();
        return arr.length <= 1 ? new int[]{-1} : Arrays.stream(arr).filter(x -> x != min).toArray();

    }

}