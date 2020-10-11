package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class p17686 {
    public static void main(String[] args) {
        String[] files =  {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] results = solution(files);
    }

    public static String[] solution(String[] files) {

        Arrays.sort(files, (o1, o2) -> {
            String o1Header = o1.split("\\d+")[0].toLowerCase();
            String o2Header = o2.split("\\d+")[0].toLowerCase();
            if (!o1Header.equals(o2Header)) {
                return o1Header.compareTo(o2Header);
            } else {
                int o1Number = getNumber(o1);
                int o2Number = getNumber(o2);
                return o1Number - o2Number;
            }
        });

        return files;
    }

    public static int getNumber(String str) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                flag = true;
                sb.append(c);
            } else if (flag == true) {
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
