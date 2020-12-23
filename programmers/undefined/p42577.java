package programmers.undefined;

public class p42577 {
    public static void main(String[] args) {
        String[][] test = {
                {"119", "97674223", "1195524421"},
                {"123","456","789"},
                {"12","123","1235","567","88"}
        };

//        System.out.println("115123".startsWith("119"));
        for (String[] t : test) {
            boolean answer = solution(t);
            System.out.println(answer);
        }
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i = 0; i < phone_book.length; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i]) || phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
            }
        }
        return answer;
    }
}
