package BOJ.clazz.lv2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/10814
 * name = 나이순 정렬
 */

public class bj10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age, name));
        }

        Collections.sort(members);

        for (Member member : members) {
            bw.write(member.getAge() + " " + member.getName() + "\n");
        }

        bw.flush();
        bw.close();
    }

    static class Member implements Comparable<Member> {
        private int age;
        private String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            return this.age - o.age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
