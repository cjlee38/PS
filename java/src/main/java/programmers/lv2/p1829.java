package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class p1829 {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        int[] result = solution(m, n, picture);
        System.out.println(result[0]);
        System.out.println(result[1]);

        List<Integer> list = new ArrayList<Integer>();
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];



        int[] next;
        while((next = findNext(picture, visited)) != null) {
            numberOfArea++;
            Area area = new Area(0);
            findArea(picture, visited, next, picture[next[0]][next[1]], area);
            maxSizeOfOneArea = Math.max(area.getAreaSize(), maxSizeOfOneArea);
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void findArea(int[][] picture, boolean[][] visited, int[] pos, int current, Area area) {
        int posY = pos[0];
        int posX = pos[1];

        if (posX < 0 || posY < 0 || posX >= visited[0].length || posY >= visited.length) {
            return;
        } else if (visited[posY][posX] || picture[posY][posX] != current){
            return;
        } else {
            area.increase();
            visited[posY][posX] = true;
            findArea(picture, visited, new int[]{posY+1, posX}, current, area); // down
            findArea(picture, visited, new int[]{posY-1, posX}, current, area); // up
            findArea(picture, visited, new int[]{posY, posX-1}, current, area); // left
            findArea(picture, visited, new int[]{posY, posX+1}, current, area); // right
        }
    }

    public static int[] findNext(int[][] picture, boolean[][] visited) {
        for (int i=0; i<visited.length; i++) {
            for (int j=0; j<visited[0].length; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }
}

class Area {
    private int areaSize;

    public Area(int areaSize) {
        this.areaSize = areaSize;
    }

    public int getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int areaSize) {
        this.areaSize = areaSize;
    }

    public void increase() {
        this.areaSize++;
    }
}