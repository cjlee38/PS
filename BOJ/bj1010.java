package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class bj1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String left = st.nextToken();
            String right = st.nextToken();

            Solution1010 solution1010 = new Solution1010(left, right);
            BigInteger result = solution1010.run();
            System.out.println(result);
        }
    }
}

class Solution1010 {
    private String left;
    private String right;

    public Solution1010(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public BigInteger run() {
        BigInteger n = new BigInteger(right);
        BigInteger r = new BigInteger(left);

        return factorial(n).divide(factorial(n.subtract(r)).multiply(factorial(r)));
    }

    public BigInteger factorial(BigInteger n) {
        return n.equals(BigInteger.ZERO) ? BigInteger.ONE : n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

}
