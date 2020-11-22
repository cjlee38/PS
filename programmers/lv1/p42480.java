package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class p42480 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] answers) {
        int[] cycle_1 = {1, 2, 3, 4, 5};
        int[] cycle_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] cycle_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int count_1 = 0, count_2 = 0, count_3 = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (cycle_1[i % cycle_1.length] == answer) count_1++;
            if (cycle_2[i % cycle_2.length] == answer) count_2++;
            if (cycle_3[i % cycle_3.length] == answer) count_3++;
        }

        int max = Math.max(Math.max(count_1, count_2), count_3);

        List<Integer> list = new ArrayList<>();
        if (max == count_1) list.add(1);
        if (max == count_2) list.add(2);
        if (max == count_3) list.add(3);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
