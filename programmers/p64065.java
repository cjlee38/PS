package programmers;


import java.util.HashMap;

public class p64065 {
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] elements = s.replace("{","").replace("}","").split(",");
        
        for (String e : elements) {
            Integer key = Integer.parseInt(e);
            Integer value = map.get(key);
            if (value == null) { map.put(key, 1); }
            else { map.put(key, value + 1); }
        }
        
        HashMap<Integer, Integer> reversed = new HashMap<>();
        for (Integer i : map.keySet()) {
            reversed.put(map.get(i), i);
        }
        
        int[] answer = new int[reversed.size()];
        for(int i = 0; i < reversed.size(); i++) {
            answer[i] = reversed.get(reversed.size() - i);
        }
        return answer;
    }
}