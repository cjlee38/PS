import java.util.*;

public class Practice {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6};

        b = a;

        b[2] = 99;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }


}
