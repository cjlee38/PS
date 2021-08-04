package codetree.intermediate.low.basic.objectsort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class DistanceFromOrigin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i + 1));
        }
        Collections.sort(points);
        for (Point point : points) {
            bw.write(point.index + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static int[] getArray(int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    private static class Point implements Comparable<Point> {
        private int x;
        private int y;
        private int index;
        private int distance;

        public Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.distance = Math.abs(x) + Math.abs(y);
        }

        @Override
        public int compareTo(Point o) {
            if (this.distance != o.distance) return this.distance - o.distance;
            return this.index - o.index;
        }
    }
}
