package BOJ.tier.silver;

import static org.junit.jupiter.api.Assertions.*;

import BOJ.StreamHandlerForTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

class bj1244Test {

    private StreamHandlerForTest handler;

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void test(String input, String output) throws Exception {
        // given
        handler = new StreamHandlerForTest(input);

        // when
        bj1244.main(new String[]{}); // 테스트 실행

        // then
        assertEquals(output, handler.get());
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("8\n"
					+ "0 1 0 1 0 0 0 1\n"
					+ "2\n"
					+ "1 3\n"
					+ "2 3", "1 0 0 0 1 1 0 1"),
                Arguments.of("1\n"
					+ "1\n"
					+ "1\n"
					+ "1 1", "0"),
				Arguments.of("25\n"
					+ "0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n"
					+ "1\n"
					+ "1 1",
					"1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n"
					+ "1 0 1 0 1")
        );
    }
}