package programmers.undefined;

import java.util.LinkedList;
import java.util.Queue;

public class p42583 {

    public static void main(String[] args) {

        // case 1
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6}; // 8

        // case 2
//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10}; // 101

        // case 3
//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}; // 110

        int answer = solution(bridge_length, weight, truck_weights);
        System.out.println(answer);

    }



    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge = 0;
        boolean flag = false;
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> bridgeQ = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++) {
            Truck truck = new Truck(truck_weights[i], bridge_length);
            waitQ.add(truck);
        }


        do {
            for (Truck t : bridgeQ) {
                t.elapse();
                if (t.getTime() <= 0) {
                    flag = true;
                }
            }

            if (flag == true) {
                Truck out_truck = bridgeQ.poll();
                bridge -= out_truck.getWeight();
                flag = false;
            }

            if(!waitQ.isEmpty()) {
                Truck in_truck = waitQ.peek();
                if (weight >= bridge + in_truck.getWeight()) {
                    bridgeQ.add(waitQ.poll());
                    bridge += in_truck.getWeight();
                }
            }


            answer++;
        }while(!waitQ.isEmpty() || !bridgeQ.isEmpty());


        return answer;
    }
}


class Truck {
    private int weight;
    private int time;

    public Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }

    public int getWeight() {
        return weight;
    }

    public int getTime() {
        return time;
    }

    public void elapse() {
        this.time--;
    }
}