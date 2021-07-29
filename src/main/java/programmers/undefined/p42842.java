package programmers.undefined;

// 프로그래머스 - 카펫
public class p42842 {
    public static void main(String[] args) {
        int[] answer = solution(50, 22);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
    public static int[] solution(int brown, int yellow) {
        int term = (int) Math.sqrt(Math.pow((brown+4),2) /4 - 4 * (brown + yellow));
        int w = ((brown + 4) / 2 + term) / 2;
        int h = ((brown + 4) / 2 - term) / 2;

        return new int[]{w, h};
    }
}
