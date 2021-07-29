package BOJ.tag.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/2174
 * name = 로봇 시뮬레이션
 * tier = gold 5
 * date = 2021-07-25, 일, 0:6
 */

public class bj2174 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 5가로, 4세로
        // 세로 0, 가로 4

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = pInt(st);
        int B = pInt(st);
        int[][] map = new int[B][A];
        RobotMap robotMap = new RobotMap(A, B, map);
        st = new StringTokenizer(br.readLine());
        int n = pInt(st); // number of robots
        int m = pInt(st); // number of commands

        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Robot robot = new Robot(
                    pInt(st) - 1,
                    B - pInt(st),
                    i + 1,
                    DirectionType.valueOf(st.nextToken())
            );
            map[robot.getY()][robot.getX()] = i + 1;
            robots.add(robot);
        }

        List<Command> commands = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Command command = new Command(
                    pInt(st) - 1, // index of robot,
                    CommandType.valueOf(st.nextToken()),
                    pInt(st)
            );
            commands.add(command);
        }

        Solution s = new Solution(robotMap, robots, commands);
        bw.write(s.run());

        bw.flush();
        br.close();
        bw.close();
    }

    private static int pInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Solution {

        private final RobotMap map;
        private final List<Robot> robots;
        private final List<Command> commands;

        public Solution(RobotMap map, List<Robot> robots, List<Command> commands) {
            this.map = map;
            this.robots = robots;
            this.commands = commands;
        }

        public String run() {
            for (Command command : commands) {
                Robot robot = robots.get(command.getRobotIndex());
                try {
                    robot.perform(command.getCommandType(), command.getRepeat());
                } catch (OutOfRangeException | AccidentException e) {
                    return e.getMessage();
                }
            }
            return "OK";
        }

    } // end of class
}

class RobotMap {
    private static int width;
    private static int height;
    private static int[][] map;

    public RobotMap(int width, int height, int[][] map) {
        RobotMap.width = width;
        RobotMap.height = height;
        RobotMap.map = map;
    }

    public static boolean isOutOfRange(int x, int y) {
        return !(x >= 0 && y >= 0 && x < width && y < height);
    }

    public static int getFront(int x, int y) {
        return map[y][x] == 0 ? 0 : map[y][x];
    }

    public static void delete(int x, int y) {
        map[y][x] = 0;
    }

    public static void update(int x, int y) {
        map[y][x] = 1;
    }

    public static void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Robot {
    private int x;
    private int y;
    private int index;
    private DirectionType dir;

    public Robot(int x, int y, int index, DirectionType dir) {
        this.x = x;
        this.y = y;
        this.index = index;
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public DirectionType getDir() {
        return dir;
    }

    public int getIndex() {
        return index;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDir(DirectionType dir) {
        this.dir = dir;
    }

    public void perform(CommandType commandType, int repeat) {
        while (repeat-- > 0) {
            commandType.getRobotStrategy().action(this);
        }
    }
}

enum CommandType {
    L(new RobotTurnLeftStrategy()),
    R(new RobotTurnRightStrategy()),
    F(new RobotMoveForwardStrategy());

    private final RobotStrategy robotStrategy;

    CommandType(RobotStrategy robotStrategy) {
        this.robotStrategy = robotStrategy;
    }

    public RobotStrategy getRobotStrategy() {
        return robotStrategy;
    }
}

class Command {
    private final int robotIndex;
    private final CommandType commandType;
    private final int repeat;

    public Command(int robotIndex, CommandType commandType, int repeat) {
        this.robotIndex = robotIndex;
        this.commandType = commandType;
        this.repeat = repeat;
    }

    public int getRobotIndex() {
        return robotIndex;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public int getRepeat() {
        return repeat;
    }
}

interface RobotStrategy {
    void action(Robot robot);
}

class RobotTurnLeftStrategy implements RobotStrategy {

    @Override
    public void action(Robot robot) {
        DirectionType prev = robot.getDir().getPrev();
        robot.setDir(prev);
    }
}

class RobotTurnRightStrategy implements RobotStrategy {

    @Override
    public void action(Robot robot) {
        DirectionType next = robot.getDir().getNext();
        robot.setDir(next);
    }
}

class RobotMoveForwardStrategy implements RobotStrategy {

    @Override
    public void action(Robot robot) {
        int[] dydx = robot.getDir().getValue();
        int ny = robot.getY() + dydx[0];
        int nx = robot.getX() + dydx[1];
        int frontRobot;

        if (RobotMap.isOutOfRange(nx, ny))
            throw new OutOfRangeException(String.format("Robot %d crashes into the wall", robot.getIndex()));
        if ((frontRobot = RobotMap.getFront(nx, ny)) != 0)
            throw new AccidentException(String.format("Robot %d crashes into robot %d", robot.getIndex(), frontRobot));

        RobotMap.delete(robot.getX(), robot.getY());
        RobotMap.update(nx, ny);
        robot.setX(nx);
        robot.setY(ny);
    }
}

enum DirectionType {

    N(0, new int[]{-1, 0}),
    E(1, new int[]{0, 1}),
    S(2, new int[]{1, 0}),
    W(3, new int[]{0, -1});

    private final int index;
    private final int[] value;

    DirectionType(int index, int[] value) {
        this.index = index;
        this.value = value;
    }

    public int[] getValue() {
        return value;
    }

    private DirectionType getValueByIndex(int index) {
        for (DirectionType directionType : DirectionType.values()) {
            if (directionType.index == index)
                return directionType;
        }
        throw new RuntimeException("No Direction");
    }

    public DirectionType getNext() {
        int nextIndex = (this.index + 1) % 4;
        return getValueByIndex(nextIndex);
    }

    public DirectionType getPrev() {
        int prevIndex = (this.index == 0 ? 3 : this.index - 1);
        return getValueByIndex(prevIndex);
    }
}

class OutOfRangeException extends RuntimeException {
    public OutOfRangeException(String message) {
        super(message);
    }
}

class AccidentException extends RuntimeException {
    public AccidentException(String message) {
        super(message);
    }
}