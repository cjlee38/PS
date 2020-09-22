package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj5014 {
    public static Solution5014 init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int current = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        return new Solution5014(height, current, target, up, down);
    }

    public static void main(String[] args) throws IOException {
        Solution5014 s = init();
        String answer = s.run();
        System.out.println(answer);

    }
}

class Solution5014 {
    private int height;
    private int current;
    private int target;
    private int up;
    private int down;

    public Solution5014(int height, int current, int target, int up, int down) {
        this.height = height;
        this.current = current;
        this.target = target;
        this.up = up;
        this.down = down;
    }

    public String run() {
        String answer;
        if (!isPossible()) {
            answer = "use the stairs";
        } else {

            answer = "0";
        }

        return answer;
    }

    private boolean isPossible() {
        if ((target-current) % (up-down) == 0) {
            return true;
        } else {
            return false;
        }

    }
}