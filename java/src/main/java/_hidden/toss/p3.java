package _hidden.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/*
5
2021-07-20T07:58:08.487+09:00,e51254b0-53a3-42ec-b050-f5a8fcfaffaa,event,event_dashboard,4,0,4G,ios,4.11.13
2021-07-20T07:58:11.837+09:00,f20d15b6-cc7b-445a-8bd8-fcdcac196ca5,state,inquiry,15,0,4G,ios,4.11.13
2021-07-20T07:58:14.779+09:00,15d30c8e-cfa2-4d3b-bd1a-6bab6dd7e5b6,state,quiz_main,11,0,4G,ios,4.11.13
2021-07-20T07:58:17.112+09:00,f74ec044-0c29-4515-b6aa-af4d444047e6,event,event_timeline_detail,5,0,4G,ios,4.11.13
2021-07-20T07:58:20.105+09:00,f5f3f9d0-9c40-4972-96d6-d3a2e824d95f,state,prime_start,9,0,4G,ios,4.11.13
 */
public class p3 {
    static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            List<Log> logs = new ArrayList<>(n);
            while (n-- > 0) {
                logs.add(Log.of(br.readLine()));
            }
            Map<String, List<Log>> mapPerOS = logs.stream().collect(Collectors.groupingBy(x -> x.os));
            getVisitLog(mapPerOS.get("android"));

            System.out.println();
        }

        private static void getVisitLog(List<Log> log) {
//            log.stream()
//                    .collect(Collectors.groupingBy(x -> x.user_no))
//                    .entrySet()
//                    .stream()
//                    .map(x -> getConversionRate(x.getValue()))

        }

        private static void getConversionRate(List<Log> logs) {
            Collections.sort(logs);

        }

        static class User {

        }

        static class Log implements Comparable<Log> {
            private LocalDateTime log_time;
            private String log_id;
            private String log_type;
            private String log_name;
            private String svc_id;
            private long user_no;
            private String network;
            private String os;
            private String app_ver;

            public static Log of(String str) {
                Log log = new Log();
                StringTokenizer st = new StringTokenizer(str, ",");
                log.log_time = LocalDateTime.parse(st.nextToken(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'+09:00'"));
                log.log_id = st.nextToken();
                log.log_type = st.nextToken();
                log.log_name = st.nextToken();
                log.svc_id = st.nextToken();
                log.user_no = Long.parseLong(st.nextToken());
                log.network = st.nextToken();
                log.os = st.nextToken();
                log.app_ver = st.nextToken();
                return log;
            }

            @Override
            public String toString() {
                return "Log{" +
                        "log_time=" + log_time +
                        ", log_id='" + log_id + '\'' +
                        ", log_type='" + log_type + '\'' +
                        ", log_name='" + log_name + '\'' +
                        ", svc_id='" + svc_id + '\'' +
                        ", user_no=" + user_no +
                        ", network='" + network + '\'' +
                        ", os='" + os + '\'' +
                        ", app_ver='" + app_ver + '\'' +
                        '}';
            }

            @Override
            public int compareTo(Log o) {
                return this.log_time.compareTo(o.log_time);
            }
        }
    }
}
