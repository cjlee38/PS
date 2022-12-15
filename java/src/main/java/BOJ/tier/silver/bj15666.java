package BOJ.tier.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/15666
 * name = N과 M(12)
 * tier = silver 2
 * date = 2022-12-15, 목, 19:20
 */

public class bj15666 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //

            StringTokenizer st = tokenize(br);
            int N = sInt(st);
            int M = sInt(st);
            st = tokenize(br);
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = sInt(st);
            }
            Solution s = new Solution(N, M, numbers);
            List<List<Integer>> run = s.run();
            for (List<Integer> integers : run) {
                for (Integer integer : integers) {
                    bw.write(integer + " ");
                }
                bw.write("\n");
            }
            bw.flush();

            // == done == //
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        private int n;
        private int m;
        private int[] numbers;
        private List<List<Integer>> answers = new ArrayList<>();

        public Solution(int n, int m, int[] numbers) {
            this.n = n;
            this.m = m;
            this.numbers = numbers;
        }

        public List<List<Integer>> run() {
            List<Integer> numberList = initialize(numbers);
            find(numberList, new ArrayList<>(), 0);
            return answers;
        }

        private List<Integer> initialize(int[] numbers) {
            HashSet<Integer> set = new HashSet<>();
            for (int number : numbers) {
                set.add(number);
            }
            List<Integer> numberList = new ArrayList<>(set);
            Collections.sort(numberList);
            return numberList;
        }

        private void find(List<Integer> numbers, List<Integer> cur, int index) {
            if (cur.size() >= m) {
                answers.add(new ArrayList<>(cur));
                return;
            }
            for (int i = index; i < numbers.size(); i++) {
                cur.add(numbers.get(i));
                find(numbers, cur, i);
                cur.remove(cur.size() - 1);
            }
        }

    } // end of class
}

