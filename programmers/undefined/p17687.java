package programmers.undefined;

public class p17687 {
    final static private String[] BASE = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public static void main(String[] args) {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;
        String result = solution(n, t, m, p);
        System.out.println(result);
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t*m; i++) {
            sb.append(getNumberString(n, i));
        }


        StringBuilder tube = new StringBuilder();
        for (int i=0; i<sb.length(); i++) {
            if (tube.length() == t) {
                break;
            } else if (i % m == (p-1)) {
                tube.append(sb.charAt(i));
            }
        }

        return tube.toString();
    }

    public static String getNumberString(int n, int num) {
        StringBuilder sb = new StringBuilder();

        do {
            sb.append(BASE[num%n]);
            num /= n;
        } while (num != 0);

        return sb.reverse().toString();
    }
}