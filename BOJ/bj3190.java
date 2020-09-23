package BOJ;

// 백준 뱀

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj3190 {
    static Solution3190 init() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // size of board
        int K = sc.nextInt(); // number of apples

        int[][] board = new int[N][N];
        board[0][0] = Dummy.SNAKE;
        sc.nextLine();
        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int column = Integer.parseInt(st.nextToken()) - 1;
            board[row][column] = Dummy.APPLE;
        }

        int L = sc.nextInt(); // turn of snake
        int[][] vector = new int[L][2];
        sc.nextLine();
        for (int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            vector[i][0] =  Integer.parseInt(st.nextToken());
            vector[i][1] = st.nextToken().equals("L") ? Dummy.TURN_LEFT : Dummy.TURN_RIGHT;
        }


        return new Solution3190(board, vector);
    }

    public static void main(String[] args) throws IOException {
        Solution3190 s = init();
        int answer = s.run();
        System.out.println(answer);
    }
}

class Solution3190 {
    private int[][] map;
    private int[][] vector;

    Solution3190(int[][] map, int[][] vector) {
        this.map = map;
        this.vector = vector;
    }

    public int run() {
        int time = 0;
        Queue<Snake> list = new LinkedList<>();
        Dummy dummy = new Dummy(0, 0, Dummy.RIGHT);
        list.offer(new Snake(0, 0));

        while (true) { // game
            time++;
            boolean isDead = dummy.move(map, list);
            dummy.turn(vector, time);
            list.offer(new Snake(dummy.getHeadX(), dummy.getHeadY()));
            if (isDead) {
                break;
            }
        }

        return time;
    }

    public void printMap() {
        int N = map.length;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(" "+map[i][j]);
            }
            System.out.println();
        }
    }

    public void printVector() {
        for (int i=0; i<vector.length; i++) {
            System.out.println(vector[i][0] + " " + vector[i][1]);
        }
    }

}

class Dummy {
    public static final int APPLE = -1;
    public static final int SNAKE = 9;

    public static final int TURN_LEFT = 0;
    public static final int TURN_RIGHT = 1;

    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;

    private int headX;
    private int headY;
    private int direction;
    private int vector_pos = 0;

    public Dummy(int headX, int headY, int direction) {
        this.headX = headX;
        this.headY = headY;
        this.direction = direction;
    }

    public int getHeadX() {
        return headX;
    }

    public int getHeadY() {
        return headY;
    }

    public void turn(int[][] vector, int time) {
        if (vector_pos >= vector.length) {
            return;
        }
        int[] current = vector[vector_pos];
        if (current[0] != time) {
            return;
        } else { // turn
            if (current[1] == Dummy.TURN_LEFT) {
                this.direction += 3;
            } else {
                this.direction += 1;
            }

            this.direction %= 4;
            vector_pos++;
        }
    }

    public boolean move(int[][] map, Queue<Snake> list) {

        // move as direction
        if (direction == Dummy.UP) {
            headX--;
        } else if (direction == Dummy.RIGHT) {
            headY++;
        } else if (direction == Dummy.DOWN) {
            headX++;
        } else if (direction == Dummy.LEFT) {
            headY--;
        }

        boolean isDead = isSnakeDead(map);
        if (!isDead) {
            if(map[headX][headY] != Dummy.APPLE) {
                Snake delSnake = list.poll();
                map[delSnake.getX()][delSnake.getY()] = 0;
            }
            map[headX][headY] = Dummy.SNAKE;
        }

        return isDead;
    }

    public boolean isSnakeDead(int[][] map) {
        boolean isDead = false;
        if (headX == map.length || headY == map.length || headX == -1 || headY == -1) {
            isDead = true;
        } else if (map[headX][headY] == Dummy.SNAKE) {
            isDead = true;
        }

        return isDead;
    }
}

class Snake {
    private int X;
    private int Y;

    public Snake(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}