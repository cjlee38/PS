package codetree.intermediate.low.basic.minmax;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.*;

public class MaxOfUniqueNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(groupingBy(x -> x, counting()));
        Integer key = map.entrySet().stream()
                .filter((en) -> en.getValue() == 1)
                .map(Map.Entry::getKey)
                .max(Comparator.naturalOrder())
                .orElse(-1);

        bw.write(key + "");

        bw.flush();
        bw.close();
    }
}
