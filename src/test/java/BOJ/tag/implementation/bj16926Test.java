package BOJ.tag.implementation;

import static org.junit.jupiter.api.Assertions.*;

import BOJ.StreamHandlerForTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

class bj16926Test {

    private StreamHandlerForTest handler;

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void test(String input, String output) throws Exception {
        // given
        handler = new StreamHandlerForTest(input);

        // when
        bj16926.main(new String[]{}); // 테스트 실행

        // then
        assertEquals(output, handler.get());
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("2 2 1\n" +
                        "1 2\n" +
                        "4 3", "2 3 \n1 4 \n"),
                Arguments.of("4 4 2\n" +
                        "1 2 3 4\n" +
                        "5 6 7 8\n" +
                        "9 10 11 12\n" +
                        "13 14 15 16", "3 4 8 12 \n" +
                        "2 11 10 16 \n" +
                        "1 7 6 15 \n" +
                        "5 9 13 14 \n")
        );
    }
}