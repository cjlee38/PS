public class Practice {
    public static void main(String[] args) {
        String str = "ABCD#.";

        str.chars().map(x -> x == '.' ? 0 : 1).forEach(System.out::println);


    }
}
