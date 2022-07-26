package codetree.intermediate.low.backtracking.conditional;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Yutnori_1d {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // number of turns
        int m = Integer.parseInt(st.nextToken()); // length of board;
        int k = Integer.parseInt(st.nextToken()); // number of piece;
        int[] jumps = getArray(n);

        Solution s = new Solution(n, m, k, jumps);
        bw.write(s.run() + "");
        bw.flush();
        bw.close();
    }

    public static int[] getArray(int n) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    public static int[][] get2ndArray(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }

    static class Solution {
        private int max = 0;

        private int n; // number of turns
        private int m; // length of board
        private int k; // number of pieces
        private int[] jumps; // each means how far a piece can move

        public Solution(int n, int m, int k, int[] jumps) {
            this.n = n;
            this.m = m;
            this.k = k;
            this.jumps = jumps;
        }

        public int run() {
            List<Piece> pieces = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                pieces.add(new Piece(0));
            }

            findMaxScore(pieces, 0);
            return max;
        }

        private void findMaxScore(List<Piece> pieces, int depth) {
            if (depth == n) {
                max = Math.max(max, getScore(pieces));
                return ;
            }

            for (int i = 0; i < k; i++) {
                Piece p = pieces.get(i);
//                if (p.pos >= m - 1) continue; // if piece is in last index
                p.jump(jumps[depth]);
                findMaxScore(pieces, depth + 1);
                p.jump(-jumps[depth]);
            }
        }

        private int getScore(List<Piece> pieces) {
            return (int) pieces.stream().filter(x -> x.pos >= m - 1).count();
        }
    }

    static class Piece {
        private int pos;

        public Piece(int pos) {
            this.pos = pos;
        }

        public void jump(int jump) {
            this.pos += jump;
        }

        @Override
        public String toString() {
            return "Piece{" +
                    "pos=" + pos +
                    '}';
        }
    }
}
