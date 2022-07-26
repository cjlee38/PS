package codetree.intermediate.low.basic.objectsort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class IndicesOfSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Number> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers.add(new Number(Integer.parseInt(st.nextToken()), i));
        }
        numbers.sort(Comparator.naturalOrder());
        int[] answer = new int[n];
        for (int i = 0; i < numbers.size(); i++) {
            answer[numbers.get(i).index - 1] = i + 1;
        }
        for (int i = 0 ; i < n; i++) {
            bw.write(answer[i] + " ");
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

    static class Number implements Comparable<Number> {
        private int value;
        private int index;

        public Number(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Number o) {
            if (this.value != o.value) return this.value - o.value;
            return this.index - o.index;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }
}
