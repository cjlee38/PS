package programmers;

public class p42862 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int answer = solution(n, lost, reserve);
        System.out.println(answer);
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        for (int i=0; i<lost.length; i++) {
            for (int j=0; j<reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    reserve[j] = -1;
                    lost[i] = -1;
                    answer++;
                    break;
                }
            }
        }

        for (int i=0; i<lost.length; i++) {
            for (int j=0; j<reserve.length; j++) {
                if (lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1 ) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }


        return answer;

    }

}
