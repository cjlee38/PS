package algospot;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://algospot.com/judge/problem/read/QUADTREE
/*
4
w
xbwwb
xbwxwbbwb
xxwwwbxwxwbbbwwxxxwwbbbwwwwbb
 */
public class Quadtree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Solution> solutions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            solutions.add(new Solution(br.readLine()));
        }

        for (Solution solution : solutions) {
            String result = solution.run();
            bw.write(result + "\n");
            bw.flush();
        }
    }


    static class Solution {
        private String str;
        private int head = 0;

        public Solution(String str) {
            this.str = str;
        }

        public String run() {
            return reverse();
        }

        private String reverse() {
            char cur = str.charAt(head);
            head++;
            if (cur != 'x') return cur + "";

            String upperLeft = reverse();
            String upperRight = reverse();
            String lowerLeft = reverse();
            String lowerRight = reverse();

            return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
        }


    }
}
