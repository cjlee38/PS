public class Temp {

    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[]{2, -2, 3, 0, 4, -7};
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                if (sum == 0) count++;
            }
        }

        System.out.println("count = " + count);
    }
}
