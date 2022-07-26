package programmers.lv2;

public class p12953 {

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};

        p12953 p = new p12953();
        int result = p.solution(arr);
        System.out.println(result);
    }

    public int solution(int[] arr) {
        boolean flag = false;
        int answer = 1;

        while (true) {
            for (int i : arr) {
                if (answer % i != 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                answer++;
                flag = false;
            } else {
                break;
            }
        }

        return answer;
    }

}
