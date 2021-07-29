package programmers.lv3;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class p17676 {
    public static void main(String[] args) {
        String[] lines = new String[] {
                "2016-09-15 01:00:04.002 3.0s",
                "2016-09-15 01:00:02.500 0.001s"
        };

        Solution s = new Solution();
        int res = s.solution(lines);
        System.out.println(res);
    }

    static class Solution {
        public int solution(String[] lines) {
            int answer = -1;
            List<Time> timeList = Arrays.stream(lines)
                    .map(Time::ofLine)
                    .sorted()
                    .collect(Collectors.toList());

            for (int i = 0; i < timeList.size(); i++) {
                answer = Math.max(answer, Math.max(getTraffic(timeList.get(i).getStartTime(), timeList), getTraffic(timeList.get(i).getEndTime(), timeList)));
            }

            return answer;
        }

        private int getTraffic(Long start, List<Time> timeList) {
            int traffic = 0;
            Long end = start + 1000L;

            for (int i = 0; i < timeList.size(); i++) {
                Time current = timeList.get(i);
                if (current.getEndTime() < start) continue;
                if (current.getStartTime() > end) break;
                ++traffic;
            }
            return traffic;
        }
    }

    static class Time implements Comparable<Time> {

        private Long startTime;
        private Long endTime;

        private Time() {
        }

        public Long getStartTime() {
            return startTime;
        }


        public Long getEndTime() {
            return endTime;
        }

        public static Time ofLine(String line) {
            Time time = new Time();
            String[] s = line.split(" ");

            String[] localtime = s[1].split(":");
            long hour = Long.parseLong(localtime[0]) * 1000 * 60 * 60;
            long minute = Long.parseLong(localtime[1]) * 1000 * 60;
            long second = Long.parseLong(localtime[2].split("\\.")[0]) * 1000;
            long millis = Long.parseLong(localtime[2].split("\\.")[1]);

            long elapsed = (long) (Double.parseDouble(s[2].replace("s", "")) * 1000L);

            time.endTime = hour + minute + second + millis;
            time.startTime = time.endTime - elapsed + 1;

            return time;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

        @Override
        public int compareTo(Time o) {
            return (int) (this.startTime - o.startTime);
        }
    }
}
