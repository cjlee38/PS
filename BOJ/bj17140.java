package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj17140 { // need to be renamed as main

    static Solution init() throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[101][101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return new Solution(r, c, k, map);
    }

    public static void main(String[] args) throws IOException {
        Solution s = init();
        int answer = s.run();
        System.out.println(answer);

    }
}

class Solution {
    private int r;
    private int c;
    private int k;
    private int[][] map;

    public Solution(int r, int c, int k, int[][] map) {
        this.r = r;
        this.c = c;
        this.k = k;
        this.map = map;
    }

    public int run() {
        int time = 0;
        int rSize = 3;
        int cSize = 3;
        while(true) {
            if (time > 100) {
                time = -1;
                break;
            }
            else if (map[r][c] == k) {
                break;
            } else {
                if (rSize >= cSize) {
                    cSize = operateR(rSize, cSize);
                } else {
                    rSize = operateC(rSize, cSize);
                }
            }
            time++;
        }
        return time;
    }

    private PriorityQueue<Number> countValues(int[] values, int size) {
        Map<Integer, Integer> KV = new HashMap<>();
        PriorityQueue<Number> Q = new PriorityQueue<>();
        for(int i=0; i<size; i++) {
            if (values[i] != 0) {
                KV.compute(values[i], (k, v) -> v == null ? 1 : v + 1);
            }
        }

        for(Integer key : KV.keySet()) {
            Q.offer(new Number(key, KV.get(key)));
        }

        return Q;

    }

    private int operateR(int rSize, int cSize) {
        int newCSize = 0;
        for (int i = 0; i < rSize; i++) {
            PriorityQueue<Number> PQ = countValues(map[i], cSize);
            newCSize = PQ.size() * 2 > newCSize ? Math.min(PQ.size() * 2, 100) : newCSize;
            int idx = 0;
            while(idx < 100) {
                if (!PQ.isEmpty()) {
                    Number number = PQ.poll();
                    map[i][idx++] = number.getNum();
                    map[i][idx++] = number.getCount();
                } else {
                    map[i][idx++] = 0;
                }
            }
        }

        return newCSize;
    }


    private int operateC(int rSize, int cSize) {
        int newRSize = 0;
        for(int i=0; i<cSize; i++) {
            int[] col = new int[rSize];
            for(int j=0; j<rSize; j++) {
                col[j] = map[j][i];
            }
            PriorityQueue<Number> PQ = countValues(col, rSize);
            newRSize = PQ.size()*2 > newRSize ? Math.min(PQ.size() * 2, 100) : newRSize;
            int idx = 0;
            while(idx < 100) {
                if (!PQ.isEmpty()) {
                    Number number = PQ.poll();
                    map[idx++][i] = number.getNum();
                    map[idx++][i] = number.getCount();
                } else {
                    map[idx++][i] = 0;
                }
            }

        }
        return newRSize;
    }


}


class Number implements Comparable<Number> {
    private int num;
    private int count;

    public Number(int num, int count) {
        this.num = num;
        this.count = count;
    }

    public int getNum() {
        return num;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(Number number) {
        if (this.count == number.count) {
            return this.num > number.num ? 1 : -1;
        } else {
            return this.count > number.count ? 1 : -1;
        }
    }
}
