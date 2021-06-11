package BOJ.clazz.lv3;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/9019
 * name = DLSR
 * tier = gold 5
 */

public class bj9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Solution s = new Solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            bw.write(s.run() + "\n");
        }


        bw.flush();
        bw.close();
    }

    static class Solution {

        private int value;
        private int answer;

        public Solution(int value, int answer) {
            this.value = value;
            this.answer = answer;
        }

        public String run() {
            boolean[] visited = new boolean[10000];
            Queue<Register> Q = new LinkedList<>();
            Calculator[] commands = new Calculator[]{
                    new CommandD(),
                    new CommandS(),
                    new CommandL(),
                    new CommandR()
            };


            Q.add(new Register(value, ""));
            while (!Q.isEmpty()) {
                Register poll = Q.poll();
                if (poll.getValue() == answer)
                    return poll.getCommands();

                for (Calculator command : commands) {
                    Register nRegister = command.calculate(poll);
                    if (!visited[nRegister.getValue()]) {
                        Q.offer(nRegister);
                        visited[nRegister.getValue()] = true;
                    }
                }
            }
            return "";
        }

    } // end of class
}

class Register {

    private int value;
    private String commands;

    public Register(int value, String commands) {
        this.value = value;
        this.commands = commands;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }
}


interface Calculator {
    Register calculate(Register register);
}

class CommandD implements Calculator {

    @Override
    public Register calculate(Register register) {
        int nValue = register.getValue() * 2 % 10000;
        String nCommands = register.getCommands() + "D";

        return new Register(nValue, nCommands);
    }
}

class CommandS implements Calculator {

    @Override
    public Register calculate(Register register) {
        int value = register.getValue();
        int nValue = value <= 0 ? 9999 : value - 1;
        String nCommands = register.getCommands() + "S";
        return new Register(nValue, nCommands);
    }
}

class CommandL implements Calculator {

    @Override
    public Register calculate(Register register) {
        int value = register.getValue();
        int nValue = value % 1000 * 10 + value / 1000;
        String nCommands = register.getCommands() + "L";

        return new Register(nValue, nCommands);
    }
}

class CommandR implements Calculator {

    @Override
    public Register calculate(Register register) {
        int value = register.getValue();
        int nValue = value % 10 * 1000 + value / 10;

        String nCommands = register.getCommands() + "R";

        return new Register(nValue, nCommands);
    }
}