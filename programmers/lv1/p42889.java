package programmers.lv1;


import java.util.*;

// 프로그래머스 - 실패율
public class p42889 {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//        int[] stages = {1, 1, 1, 1, 1};
        int[] result = solution(N, stages);
        for(int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int N, int[] stages) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(stages)
                .forEach(stage -> map.compute(stage, (k, v) -> v == null? 1 : v+1));


        List<Stage> stageList = new ArrayList<>();
        int len = stages.length;
        for (int i=1; i<N+1; i++) {
            int numerator = map.getOrDefault(i, 0);
            int denominator = len;
            float failure = denominator == 0 ? 0 : numerator / (float) denominator;
            stageList.add(new Stage(i, failure));
            len -= numerator;
        }

        return stageList.stream()
                .sorted()
                .mapToInt(x -> x.getStage())
                .toArray();
    }
}

class Stage implements Comparable<Stage> {
    private int stage;
    private float failure;

    public Stage(int stage, float failure) {
        this.stage = stage;
        this.failure = failure;
    }

    public int getStage() {
        return stage;
    }

    public float getFailure() {
        return failure;
    }

    @Override
    public int compareTo(Stage o) {
        if (this.failure == o.failure) {
            return this.stage - o.stage;
        } else {
            return this.failure > o.failure ? -1 : 1;
        }

    }
}