package programmers.weekly;

public class p83201 {
    public static void main(String[] args) {
        int[][] scores_1 = new int[][]{{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        int[][] scores_2 = new int[][]{{50, 90}, {50, 87}};
        int[][] scores_3 = new int[][]{{70, 49, 90}, {68, 50, 38}, {73, 31, 100}};
        Solution s = new Solution();
        String a = s.solution(scores_1);
        System.out.println();
        String b = s.solution(scores_2);
        System.out.println();
        String c = s.solution(scores_3);
        assert a.equals("FBABD");
        assert b.equals("DA");
        assert c.equals("CFD");
        System.out.println("success");
    }
    static class Solution {

        public String solution(int[][] scores) {
            int n = scores.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int[] row = new int[n];
                for (int j = 0; j < n; j++) {
                    row[j] = scores[j][i];
                }
                double mean = getMean(row, i);
                String e = evaluate(mean);
                sb.append(e);
            }
            return sb.toString();
        }

        private String evaluate(double mean) {
            if (mean >= 90) return "A";
            else if (mean >= 80) return "B";
            else if (mean >= 70) return "C";
            else if (mean >= 50) return "D";
            else return "F";
        }

        private double getMean(int[] row, int idx) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            double sum = 0;
            int selfScore = row[idx];
            int count = 0;
            for (int i = 0; i < row.length; i++) {
                if (min > row[i]) min = row[i];
                if (max < row[i]) max = row[i];
                if (row[i] == selfScore) count++;
                sum += row[i];
            }

            if (count == 1) {
                if (min == selfScore || max == selfScore) {
                    sum -= selfScore;
                    return sum / (row.length - 1);
                }
            }
            return sum / row.length;
        }
    }
}
