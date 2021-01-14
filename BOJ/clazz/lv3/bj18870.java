package BOJ.clazz.lv3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/18870
 * name = 좌표 압축
 * tier = silver 2
 */

public class bj18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < n; i++)
            if (!map.containsKey(sorted[i]))
                map.put(sorted[i], idx++);

        for (int i = 0; i < n; i++)
            bw.write(map.get(nums[i]) + " ");

        bw.flush();
        bw.close();
    }
}
