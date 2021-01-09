import java.util.*;

public class Practice {
    public static void main(String[] args) {
        int s = 3;
        int[] arr = {1, 744, 755, 4, 897, 902, 890, 6, 777};

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        sum /= arr.length;
        sum /= s;

        System.out.println("sum = " + sum);

    }


}
