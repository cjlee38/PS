package BOJ.tag.implementation;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * uri = https://www.acmicpc.net/problem/1089
 * name = 스타트링크 타워
 * tier = gold 5
 * date = 2021-07-31, 토, 20:57
 */

public class bj1089 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //
            int n = bInt(br);
            int width = (n * 4) - 1;
            int height = 5;
            int[][] numbers = new int[height][width];
            for (int i = 0; i < height; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < width; j++) {
                    numbers[i][j] = chars[j] == '#' ? 1 : 0;
                }
            }

            Solution s = new Solution(n, width, height, numbers);
            bw.write(s.run());
            // == done //
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 0 -> 012 -> i = 0;
        // 1 -> 456 -> 3 + 1, 4 + 1,
        // 2 -> 8910
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
        private int W;
        private int H;
        private int[][] numbers;

        public Solution(int n, int w, int h, int[][] numbers) {
            this.n = n;
            W = w;
            H = h;
            this.numbers = numbers;
        }

        public String run() {
            double sum = 0;
            List<Set<Integer>> list = IntStream.range(0, n)
                    .mapToObj(x -> new BulbNumber(split(x * 4)))
                    .map(BulbNumber::getCandidates)
                    .collect(Collectors.toList());

            for (Set<Integer> em : list) {
                if (em.isEmpty()) return "-1";
                long temp = em.stream().mapToLong(x -> (long) x).sum();
                sum += (double) temp / em.size();
                sum *= 10;
            }
            return String.format("%.1f", sum / 10);
        }

        private int[][] split(int index) {
            int[][] ret = new int[5][3];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    ret[i][j] = numbers[i][j + index];
                }
            }
            return ret;
        }

        // 0 1 2
        // 4 5 6
        // 8 9 10

    } // end of class

    static class BulbNumber {
        private static BulbNumber ZERO = new BulbNumber(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 0, 1}, {1, 0, 1}, {1, 1, 1}});
        private static BulbNumber ONE = new BulbNumber(new int[][]{{0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}});
        private static BulbNumber TWO = new BulbNumber(new int[][]{{1, 1, 1}, {0, 0, 1}, {1, 1, 1}, {1, 0, 0}, {1, 1, 1}});
        private static BulbNumber THREE = new BulbNumber(new int[][]{{1, 1, 1}, {0, 0, 1}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}});
        private static BulbNumber FOUR = new BulbNumber(new int[][]{{1, 0, 1}, {1, 0, 1}, {1, 1, 1}, {0, 0, 1}, {0, 0, 1}});
        private static BulbNumber FIVE = new BulbNumber(new int[][]{{1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}});
        private static BulbNumber SIX = new BulbNumber(new int[][]{{1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        private static BulbNumber SEVEN = new BulbNumber(new int[][]{{1, 1, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}});
        private static BulbNumber EIGHT = new BulbNumber(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        private static BulbNumber NINE = new BulbNumber(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}});
        private static List<BulbNumber> DECIMAL = Arrays.asList(ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE);

        private int[][] lights;

        public BulbNumber(int[][] lights) {
            this.lights = lights;
        }

        public static Set<Integer> getCandidates(BulbNumber bulbNumber) {
            Set<Integer> candidates = new HashSet<>();
            for (int i = 0; i < DECIMAL.size(); i++) {
                if (fit(bulbNumber, DECIMAL.get(i)))
                    candidates.add(i);
            }
            return candidates;
        }

        private static boolean fit(BulbNumber cur, BulbNumber expected) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    if (cur.lights[i][j] == 1 && expected.lights[i][j] == 0)
                        return false;
                }
            }
            return true;
        }


    }
}

