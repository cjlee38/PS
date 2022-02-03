package BOJ.tier.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/7562
 * name = 나이트의 이동
 * tier = silver 2
 * date = 2022-02-3, 목, 18:25
 */

public class bj7562 {

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            // == do == //

			int t = bInt(br);
			while (t-- > 0) {
				int l = bInt(br);
				StringTokenizer st = tokenize(br);
				int[] pos = new int[] {sInt(st), sInt(st)};
				st = tokenize(br);
				int[] dest = new int[] {sInt(st), sInt(st)};

				Solution s = new Solution(l, pos, dest);
				int res = s.run();
				bw.write(res + "\n");
			}
			// == done == //
			bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

		private static final int[] dx = new int[] {1, 2, 2, 1, -1, -2, -2, -1};
		private static final int[] dy = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};

    	private int l;
    	private int[] pos;
    	private int[] dest;

		public Solution(int l, int[] pos, int[] dest) {
			this.l = l;
			this.pos = pos;
			this.dest = dest;
		}

		public int run() {
			int[][] visited = new int[l][l];
			Queue<Position> Q = new LinkedList<>();
			Q.offer(new Position(pos[0], pos[1]));

			while (!Q.isEmpty()) {
				Position poll = Q.poll();
				if (isDestination(poll)) {
					return visited[poll.y][poll.x];
				}
				for (int i = 0; i < dx.length; i++) {
					int nx = poll.x + dx[i];
					int ny = poll.y + dy[i];
					if (isInRange(nx, ny) && visited[ny][nx] == 0) {
						Q.offer(new Position(nx, ny));
						visited[ny][nx] = visited[poll.y][poll.x] + 1;
					}
				}
			}
			return -1;
        }

		private boolean isInRange(int x, int y) {
			return x >= 0 && y >= 0 && x < l && y < l;
		}

		private boolean isDestination(Position pos) {
			return pos.x == dest[0] && pos.y == dest[1];
		}
	} // end of class

	static class Position {
    	private int x;
    	private int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

