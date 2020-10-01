package programmers;


public class Main {
    public static void main(String[] args) {

        int num = 3;
        String result = solution(num);
        System.out.println(result);
    }

    public static String solution(int num) {
        return num%2 == 0 ? "Even" : "Odd";
    }

}