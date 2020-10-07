package programmers;

public class p67257 {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        long result = solution(expression);
    }
    public static long solution(String expression) {
        long answer = 0;
        String[] temp = expression.split("[-+*]");
        String[] temp2 = expression.split("\\d+");
        System.out.println(temp.length);
        for(String t : temp2) {
            if (!t.equals(""))
            System.out.println(t);
        }
        return answer;
    }
}
