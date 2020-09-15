package programmers;

public class p42883 {
    public static void main(String[] args) {
        String Number = "4577252841";
        int k = 4;

        System.out.println(solution(Number, k));
    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < number.length()-1 ; i++) {
            System.out.println("i : "+ String.valueOf(i));
            if (Character.getNumericValue(number.charAt(i)) > Character.getNumericValue(number.charAt(i+1))) {
                sb.append(number.charAt(i));
                System.out.println("current : " + sb.toString());
            }

            if (sb.length() >= k) {
                break;
            }
        }

        return sb.toString();
    }


}