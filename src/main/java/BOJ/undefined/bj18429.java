package BOJ.undefined;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18429 {
    static Solution18429 init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] kits = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        return new Solution18429(kits, K);
    }

    public static void main(String[] args) throws IOException {
        Solution18429 solution18429 = init();
        int result = solution18429.run();
        System.out.println(result);
    }
}

class Solution18429 {
    final private int kits[];
    final private int K;

    public Solution18429(int[] kits, int k) {
        this.kits = kits;
        K = k;
    }

    public int run() {
        boolean[] visited = new boolean[kits.length];
        int answer = recursive(visited, 0, 500);
        return answer;
    }

    public int recursive(boolean[] visited, int index, int cur) {
        if(index == kits.length) {
            return 1;
        }

        int val = 0;
        for (int i=0; i<kits.length; i++) {
            if (visited[i])
                continue;
            int next = cur - K + kits[i];
            if (next >= 500) {
                visited[i] = true;
                val += recursive(visited, index+1, next);
                visited[i] = false;
            }
        }

        return val;
    }
}
