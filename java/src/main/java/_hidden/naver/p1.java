package _hidden.naver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p1 {
    public static void main(String[] args) {
        String str = "011100";
        Solution s = new Solution();
        int res = s.solution(str);
        System.out.println(res);
    }
    static class Solution {
        public int solution(String S) {
            int cnt = 0;
            int index = -1;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '1') {
                    index = i;
                    break ;
                }
            }
            assert index != -1;
            System.out.println(index);
            StringBuilder sb = new StringBuilder(S.substring(index));
            while (sb.length() != 0) {
                cnt++;
                if (isEven(sb)) {
                    sb.deleteCharAt(sb.length() - 1); // operation >>
                }
                else sb.setCharAt(sb.length() - 1, '0'); // make 0 at end of string
            }
            return cnt - 1;
        }

        private boolean isEven(StringBuilder sb) {
            return sb.charAt(sb.length() - 1) == '0';
        }
    }
}
