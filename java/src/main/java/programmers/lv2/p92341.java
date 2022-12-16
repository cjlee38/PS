package programmers.lv2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class p92341 {

    public static void main(String[] args) {
        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };
        Solution s = new Solution();
        int[] result = s.solution(fees, records);
        System.out.println(Arrays.toString(result));
    }

    private static class Solution {

        private int defaultMinutes;
        private int defaultCost;
        private int unit;
        private int costPerUnit;

        public int[] solution(int[] fees, String[] records) {
            initialize(fees);
            Map<String, LocalTime> carRecords = new HashMap<>();
            Map<String, Integer> times = new TreeMap<>();
            for (String record : records) {
                String[] splitted = record.split(" ");
                String[] timeString = splitted[0].split(":");
                LocalTime time = LocalTime.of(Integer.parseInt(timeString[0]), Integer.parseInt(timeString[1]));
                if ("IN".equals(splitted[2])) {
                    carRecords.put(splitted[1], time);
                } else {
                    LocalTime before = carRecords.remove(splitted[1]);
                    LocalTime after = time;
                    int duration = between(before, after);
                    times.compute(splitted[1], (k, v) -> v == null ? duration : v + duration);

                }
            }

            for (Entry<String, LocalTime> entry : carRecords.entrySet()) {
                int duration = between(entry.getValue(), LocalTime.of(23, 59));
                times.compute(entry.getKey(), (k, v) -> v == null ? duration : v + duration);
            }

            for (Entry<String, Integer> entry : times.entrySet()) {
                calculateCost(entry.getValue());
            }
            return times.entrySet().stream()
                    .mapToInt(entry -> calculateCost(entry.getValue()))
                    .toArray();
        }

        private void initialize(int[] fees) {
            defaultMinutes = fees[0];
            defaultCost = fees[1];
            unit = fees[2];
            costPerUnit = fees[3];
        }

        private int between(LocalTime start, LocalTime end) {
            return (int) Duration.between(start, end).toMinutes();
        }

        private int calculateCost(long delta) {
            double rest = Math.ceil((double) (delta - defaultMinutes) / unit);
            if (rest <= 0) {
                rest = 0;
            }
            return (int) (defaultCost + rest * costPerUnit);
        }

    }
}
