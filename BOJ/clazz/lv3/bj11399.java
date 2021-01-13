package BOJ.clazz.lv3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/11399
 * name = ATM
 * tier = silver 3
 */

public class bj11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            list.add(new Person(i, p));
        }

        Collections.sort(list);
        int sum = 0;
        int cur = 0;
        for (Person person : list) {
            cur += person.getTime();
            sum += cur;
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }

    static class Person implements Comparable<Person> {

        private int index;
        private int time;

        public Person(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return index;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(Person o) {
            return this.time - o.time;
        }
    } // end of class
}
