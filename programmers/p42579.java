package programmers;

import java.util.*;

public class p42579 {
    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop", "classic"};
//        int[] plays = {500, 600, 150, 800, 2500, 900};

        String[] genres = {"classic", "classic", "classic", "classic", "pop"};
        int[] plays = {500, 150, 800, 800, 2500};
        int[] answer = solution(genres, plays);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> gMap = new HashMap<>();
        Map<Integer, String> rgMap = new HashMap<>();
        Map<String, Song> sMap = new HashMap<>();
        List<Integer> indices = new ArrayList<>();

        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            gMap.compute(genre, (k, v) -> v == null? play : v + play);
            if (sMap.get(genre) == null) {
                sMap.put(genre, new Song());
            }
            sMap.get(genre).addValue(play, i);
        }


        List<Integer> sumOfPlays = new ArrayList<>(gMap.values());
        sumOfPlays.sort(Comparator.reverseOrder());
        gMap.forEach((k, v) -> rgMap.put(v, k));

        for (Integer p : sumOfPlays) {
            Song song = sMap.get(rgMap.get(p));
            if (song.getFirstIndex() != -1) {
                indices.add(song.getFirstIndex());
            }
            if (song.getSecondIndex() != -1) {
                indices.add(song.getSecondIndex());
            }


        }

        return indices.stream().mapToInt(Integer::valueOf).toArray();
    }

//    public static int[] solution(String[] genres, int[] plays) {
//        Map<String, Integer> index = new HashMap<>();
//        Map<Integer, String> rIndex = new HashMap<>();
//        Map<String, Map<Integer, Integer>> map = new HashMap<>();
//        List<Integer> answer = new ArrayList<>();
//
//
//        for (int i = 0; i < genres.length; i++) {
//            String genre = genres[i];
//            Integer play = plays[i];
//            if (map.get(genre) == null) {
//                index.put(genre, play);
//                Map<Integer, Integer> temp = new HashMap<>();
//                temp.put(i, play);
//                map.put(genre, temp);
//            } else { // if exists
//                index.put(genre, index.get(genre) + play);
//                map.get(genre).put(i, play);
//            }
//        }
//
//        ArrayList<Integer> list = new ArrayList();
//        list.addAll(index.values());
//        list.sort(Comparator.reverseOrder());
//        index.forEach((k, v) -> rIndex.put(v, k));
//
//        for(Integer i : list) {
//            String name = rIndex.get(i);
//            Map<Integer, Integer> current = map.get(name);
//            ArrayList<Integer> values = new ArrayList<>();
//            values.addAll(current.values());
//            values.sort(Comparator.reverseOrder());
//
//            System.out.println(values);
//
//            int max_1 = -1;
//            int max_2 = -1;
//            for (Integer j : current.keySet()) {
//                if (current.get(j) == values.get(0)) {
//                    max_1 = j;
//                }
//                if (current.get(j) == values.get(1)) {
//                    max_2 = j;
//                }
//            }
//
//            answer.add(max_1);
//            answer.add(max_2);
//        }
//
//        int[] pAnswer = new int[answer.size()];
//        for(int i = 0; i < pAnswer.length; i++) {
//            pAnswer[i] = answer.get(i);
//        }
//
//        return pAnswer;
//
//    }
}


class Song {
    private int firstIndex;
    private int firstPlay;
    private int secondIndex;
    private int secondPlay;

    public Song() {
        this.firstIndex = -1;
        this.firstPlay = Integer.MIN_VALUE;
        this.secondIndex = -1;
        this.secondPlay = Integer.MIN_VALUE;
    }

    void addValue(int play, int index) {
        if (play > firstPlay) {
            secondPlay = firstPlay;
            firstPlay = play;
            secondIndex = firstIndex;
            firstIndex = index;
        } else if ( play <= firstPlay && secondPlay < play) {
            secondPlay = play;
            secondIndex = index;
        }
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

}