package BOJ.clazz.lv3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1697
 * name = 숨바꼭질
 */

public class bj1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        final int MAX = 100001;
        boolean[] visited = new boolean[MAX];
        Queue<Integer> Q = new LinkedList<>();

        visited[n] = true;
        Q.offer(n);
        b: while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                int cur = Q.poll();
                if (cur == k) break b;

                for (int j = 0; j < 3; j++) {
                    int next;
                    if (j == 0) next = cur - 1;
                    else if (j == 1) next = cur + 1;
                    else next = cur * 2;

                    if (0 <= next && next < MAX && !visited[next]) {
                        Q.offer(next);
                        visited[next] = true;
                    }
                }
            }
            count++;
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}
