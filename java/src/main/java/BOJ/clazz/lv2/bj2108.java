package BOJ.clazz.lv2;

import java.io.*;
import java.util.*;

/**
 * uri = https://www.acmicpc.net/problem/2108
 * name = 통계학
 */

public class bj2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Solution s = new Solution(n, arr);
        int[] result = s.run();
        for (int r : result) {
            bw.write(r + "\n");
        }


        bw.flush();
        bw.close();
    }

    static class Solution {

        private int n;
        private int[] arr;

        public Solution(int n, int[] arr) {
            this.n = n;
            this.arr = arr;
        }

        public int[] run() {
            Arrays.sort(arr);

            int mean = getMean();
            int median = getMedian();
            int mode = getMode();
            int range = getRange();

            return new int[]{mean, median, mode, range};
        }

        private int getMean() {
            double sum = 0;
            for (int r : arr) {
                sum += r;
            }
            return (int) Math.round(sum / n);
        }

        private int getMedian() {
            return arr[(n + 1) / 2 - 1];
        }

        private int getMode() {
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> counter = new HashMap<>();
            Arrays.stream(arr).forEach(x -> counter.compute(x, (k, v) -> v == null ? 1 : v + 1));

            int count = 0;

            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if (value > count) {
                    count = value;
                    list.clear();
                    list.add(key);
                } else if (value == count) {
                    list.add(key);
                }
            }

            if (list.size() > 1) {
                Collections.sort(list);
                return list.get(1);
            } else {
                return list.get(0);
            }
        }

        private int getRange() {
            return Math.abs(arr[n -1] - arr[0]);
        }
    }
}
