package _hidden.programmers.montly42_2;

public class p3 {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        String[] s = {"1110","100111100","0111111010"};
        String[] s = {"11111110"};
        String[] solution = sol.solution(s);
        for (String s1 : solution) {
            System.out.println(s1);
        }
    }
    static class Solution {
        public String[] solution(String[] s) {
            String[] answer = new String[s.length];
            for (int i = 0; i < s.length; i++)
                answer[i] = solve(s[i]);

            return answer;
        }
        public String solve(String s) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length() - 2; i++) {
                System.out.println(sb.substring(i, i + 3));
                if (sb.substring(i, i + 3).equals("110")) {
                    while (i + 3 < s.length() && sb.charAt(i + 3) == '0') {
                        sb = sb.deleteCharAt(i + 3);
                        sb = sb.insert(i, '0');
                    }

                    while (i > 0 && sb.charAt(i - 1) == '1') {
                        sb = sb.deleteCharAt(i - 1);
                        sb = sb.insert(i + 2, '1');
                        System.out.println("ing" + sb.toString());
                    }

                }
            }
            System.out.println("-----------");
            return sb.toString();
        }
    }
}
