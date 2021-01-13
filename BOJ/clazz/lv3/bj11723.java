package BOJ.clazz.lv3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * uri = https://www.acmicpc.net/problem/11723
 * name = 집합
 * tier = silver 5
 */

public class bj11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x;
            if (!command.equals("all") && !command.equals("empty")) x = Integer.parseInt(st.nextToken());
            else x = -1;

            if (command.equals("add")) set.add(x);
            else if (command.equals("remove")) set.remove(x);
            else if (command.equals("check")) if (set.contains(x)) bw.write("1\n"); else bw.write("0\n");
            else if (command.equals("toggle")) if (set.contains(x)) set.remove(x); else set.add(x);
            else if (command.equals("all")) set = IntStream.range(1, 21).boxed().collect(Collectors.toSet());
            else if (command.equals("empty")) set = new HashSet<>();

        }


        bw.flush();
        bw.close();
    }

}
