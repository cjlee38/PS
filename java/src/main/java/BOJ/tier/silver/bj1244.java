package BOJ.tier.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * uri = https://www.acmicpc.net/problem/1244
 * name = 스위치 끄고 켜기
 * tier = silver 3
 * date = 2022-02-5, 토, 17:19
 */

public class bj1244 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            int numOfSwitches = bInt(br);
            boolean[] switches = readSwitches(br, numOfSwitches);
            int numOfStudents = bInt(br);
            List<Student> students = readStudents(br, numOfStudents);

            Solution s = new Solution(numOfSwitches, switches, students);
            boolean[] res = s.run();
            writeAnswer(bw, res);
            bw.flush();
            // == done == //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeAnswer(BufferedWriter bw, boolean[] res) throws IOException {
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i != 0 && i % 20 == 0) {
                bw.write(row.toString().strip() + "\n");
                row = new StringBuilder();
            }
            String v = res[i] ? "1 " : "0 ";
            row.append(v);
        }
        bw.write(row.toString().strip());
    }

    private static boolean[] readSwitches(BufferedReader br, int numOfSwitches) throws IOException {
        int[] ints = readInts(br, numOfSwitches);
        boolean[] switches = new boolean[numOfSwitches];
        for (int i = 0; i < switches.length; i++) {
            switches[i] = ints[i] == 1;
        }
        return switches;
    }

    private static List<Student> readStudents(BufferedReader br, int numOfStudents) {
        return IntStream.range(0, numOfStudents)
            .mapToObj(x -> readStudent(br))
            .collect(Collectors.toList());
    }

    private static Student readStudent(BufferedReader br) {
        StringTokenizer st = null;
        try {
            st = tokenize(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert st != null;
        boolean isMale = sInt(st) == 1;
        int number = sInt(st);
        return new Student(isMale, number);
    }

    private static int[] readInts(BufferedReader br, int n) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        return IntStream.range(0, n).map(x -> Integer.parseInt(st.nextToken())).toArray();
    }

    private static StringTokenizer tokenize(BufferedReader br) throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static int bInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int sInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private int numOfSwitches;
        private boolean[] switches;
        private List<Student> students;

        public Solution(int numOfSwitches, boolean[] switches, List<Student> students) {
            this.numOfSwitches = numOfSwitches;
            this.switches = switches;
            this.students = students;
        }

        public boolean[] run() {
            for (Student student : students) {
                if (student.isMale) {
                    toggleMultiple(student.number);
                } else {
                    toggleSide(student.number);
                }
            }
            return switches;
        }

        private void toggleSide(int number) {
            toggle(number);
            int left = number - 1;
            int right = number + 1;
            while (isInRange(left, right) && isSideSame(left, right)) {
                toggle(left);
                toggle(right);
                left--;
                right++;
            }
        }

        private boolean isSideSame(int left, int right) {
            return switches[left - 1] == switches[right - 1];
        }

        private boolean isInRange(int left, int right) {
            return left >= 1 && right <= numOfSwitches;
        }

        private void toggleMultiple(int number) {
            for (int i = number; i <= numOfSwitches; i += number) {
                toggle(i);
            }
        }

        private void toggle(int number) {
            switches[number - 1] = !switches[number - 1];
        }

    } // end of class

    static class Student {
        boolean isMale;
        int number;

        public Student(boolean isMale, int number) {
            this.isMale = isMale;
            this.number = number;
        }
    }
}

