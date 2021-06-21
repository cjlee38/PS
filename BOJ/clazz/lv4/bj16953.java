package BOJ.clazz.lv4;

import java.io.*;
import java.util.*;

/**
 * uri = https://www.acmicpc.net/problem/16953
 * name = A -> B
 * tier = silver 1
 */

public class bj16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Solution s = new Solution(start, end);
        bw.write(s.run() + "");

        bw.flush();
        bw.close();
    }

    static class Solution {

        private int start;
        private int end;

        public Solution(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int run() {
            int count = 1;
            while (start != end) {
                if (start > end) return -1;

                if (end % 10 == 1) end /= 10;
                else if (end % 2 == 0) end /= 2;
                else return -1;

                count++;
            }
            return count;
        }

    } // end of class
}

