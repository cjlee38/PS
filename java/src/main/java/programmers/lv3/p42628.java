package programmers.lv3;

import java.util.*;

public class p42628 {
    public static void main(String[] args) {
//        String[] operations = {"I -7", "D 1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] result = solution(operations);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(String[] operations) {
        int[] answer;
        List<Integer> list = generateList(operations);

        if (list.size() == 0) answer = new int[]{0, 0};
        else answer = new int[]{
                list.get(list.size()-1),
                list.get(0)
        };


        return answer;
    }

    public static List<Integer> generateList(String[] operations) {
        List<Integer> list = new ArrayList<>();

        for (String operation : operations) {
            String[] splited = operation.split(" ");
            String op = splited[0];
            Integer num = Integer.valueOf(splited[1]);


            if (op.equals("I")) doInsert(list, num);
            else if (op.equals("D")) doDelete(list, num);
        }

        return list;
    }

    public static void doInsert(List<Integer> list, Integer num) {
        list.add(num);
        list.sort(Comparator.naturalOrder());
    }

    public static void doDelete(List<Integer> list, Integer num) {
        if (list.size() == 0) return;


        int idx = num == 1 ? list.size()-1 : 0;
        list.remove(idx);
    }

}
