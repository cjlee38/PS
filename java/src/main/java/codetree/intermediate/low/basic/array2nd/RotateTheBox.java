package codetree.intermediate.low.basic.array2nd;

import java.io.*;
import java.util.StringTokenizer;

public class RotateTheBox {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] box = new int[n][n];
        for (int i = 0; i < n; i++) {
            box[i] = getArray(n, br);
        }
        int[][] rot = rotate(n, box);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(rot[i][j] + " ");
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
    }

    private static int[][] rotate(int n, int[][] box) {
        int[][] rot = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rot[i][j] = box[n - j - 1][i];
            }
        }
        return rot;
    }

    public static int[] getArray(int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
