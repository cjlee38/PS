package _hidden.naver;

public class p3 {
    public static void main(String[] args) {
//        int[] A = new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
        int[] A = {5, 8};
        Solution s = new Solution();
        int res = s.solution(A);
        System.out.println(res);
    }

    static class Solution {
        public int solution(int[] A) {
            int h = 0;
            int ans = 0;
            for (int i = 0; i < A.length; i++) {
                if (h < A[i]) {
                    System.out.println(A[i] - h);
                    ans += A[i] - h;
                }
                h = A[i];
            }
            return ans;
        }
    }
}
