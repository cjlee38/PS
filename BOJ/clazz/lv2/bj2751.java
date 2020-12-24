package BOJ.clazz.lv2;

import java.io.*;
import java.util.*;

/**
 * uri = https://www.acmicpc.net/problem/2751
 * name = 수 정렬하기 2
 */

public class bj2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++ ){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (Integer v : list) {
            bw.write(v + "\n");
        }

        bw.flush();
        bw.close();
    }

}
