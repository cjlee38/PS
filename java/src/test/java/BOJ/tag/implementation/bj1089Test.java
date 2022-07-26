package BOJ.tag.implementation;

import static org.junit.jupiter.api.Assertions.*;
import BOJ.StreamHandlerForTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

class bj1089Test {

    private StreamHandlerForTest handler;

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void test(String input, String output) throws Exception {
        // given
        handler = new StreamHandlerForTest(input);

        // when
        bj1089.main(new String[]{}); // 테스트 실행

        // then
        assertEquals(output, handler.get());
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("1\n" +
                        "###\n" +
                        "#.#\n" +
                        "###\n" +
                        "#.#\n" +
                        "###", "8.0"),
                Arguments.of("2\n" +
                        "###.###\n" +
                        "#.#.#.#\n" +
                        "#.#.###\n" +
                        "#.#...#\n" +
                        "###.###", "48.5"),
                Arguments.of("2\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......", "49.5"),
                Arguments.of("1\n" +
                        "...\n" +
                        ".#.\n" +
                        "...\n" +
                        "...\n" +
                        "...", "-1"),
                Arguments.of("9\n" +
                        "..#...#...#...#...#...#...#...#...#\n" +
                        "...................................\n" +
                        "..#...#...#...#...#...#...#...#...#\n" +
                        "...................................\n" +
                        "..#...#...#...#...#...#...#...#...#", "499999999.5"),
                Arguments.of("1\n" +
                        "...\n" +
                        ".#.\n" +
                        "...\n" +
                        ".#.\n" +
                        "...", "-1")
        );
    }
}