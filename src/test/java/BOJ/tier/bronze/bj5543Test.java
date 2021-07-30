package BOJ.tier.bronze;

import static org.junit.jupiter.api.Assertions.*;

import BOJ.StreamHandlerForTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

class bj5543Test {

    private StreamHandlerForTest handler;

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void test(String input, String output) throws Exception {
        // given
        handler = new StreamHandlerForTest(input);

        // when
        bj5543.main(new String[]{}); // 테스트 실행

        // then
        assertEquals(output, handler.get());
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("800\n" +
                        "700\n" +
                        "900\n" +
                        "198\n" +
                        "330", "848"),
                Arguments.of("1999\n" +
                        "1999\n" +
                        "100\n" +
                        "189\n" +
                        "100", "150")
        );
    }
}