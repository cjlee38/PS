package programmers.undefined;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class p67257 {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        String expression2 = "50*6-3*2";
        long result = solution(expression2);
        System.out.println("fin : " + result);
    }
    public static long solution(String expression) {
        long answer = 0;

        long[] numbers = Arrays.stream(expression.split("[-+*]"))
                .mapToLong(Long::parseLong)
                .toArray();
        String[] operators = Arrays.stream(expression.split("\\d+"))
                .filter(x -> !x.equals(""))
                .toArray(String[]::new);

        String[][] operatorPriorities = getOperatorPriorities();

        for (String[] priorities : operatorPriorities) {
            answer = Math.max(answer, Math.abs(calcByPriority(numbers, operators, priorities)));
        }


        return answer;
    }

    public static String[][] getOperatorPriorities() {
        // can be replace with DFS
        return new String[][] {
                {"+", "-", "*"},
                {"+", "*", "-"},
                {"-", "+", "*"},
                {"-", "*", "+"},
                {"*", "+", "-"},
                {"*", "-", "+"}
        };
    }

    public static long calcByPriority(long[] numbers, String[] operators, String[] priority) {
        List<Long> numList = LongStream.of(numbers).boxed().collect(Collectors.toCollection(LinkedList::new));
        List<String> opList = Arrays.stream(operators).collect(Collectors.toCollection(LinkedList::new));

        for (String prior : priority) {
            calcOnOperator(numList, opList, prior);
        }

        return numList.get(0);
    }

    public static void calcOnOperator(List<Long> numList, List<String> opList, String curOperator) {
        for (int j=0; j<opList.size(); j++) {
            if (opList.get(j).equals(curOperator)) {
                String operator = opList.remove(j);
                long prevNum = numList.remove(j);
                long nextNum = numList.remove(j);
                numList.add(j, threeCalc(operator, prevNum, nextNum));
                j--;
            }
        }
    }

    public static long threeCalc(String operator, long prevNum, long nextNum) {
        if (operator.equals("+")) return prevNum + nextNum;
        if (operator.equals("*")) return prevNum * nextNum;
        else return prevNum - nextNum;
    }

}
