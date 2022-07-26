package codetree.intermediate.low.basic.objectsort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LineUpStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students.add(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
        }
        students.sort(Collections.reverseOrder());
        for (Student student : students) {
            bw.write(student.toString() + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static int[] getArray(int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    static class Student implements Comparable<Student> {
        private int height;
        private int weight;
        private int number;

        public Student(int height, int weight, int number) {
            this.height = height;
            this.weight = weight;
            this.number = number;
        }

        @Override
        public int compareTo(Student o) {
            if (this.height != o.height) return this.height - o.height;
            if (this.weight != o.weight) return this.weight - o.weight;
            return o.number - this.number;
        }

        @Override
        public String toString() {
            return height + " " + weight + " " + number;
        }
    }
}