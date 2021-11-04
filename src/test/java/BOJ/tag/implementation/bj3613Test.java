package BOJ.tag.implementation;

import static org.junit.jupiter.api.Assertions.*;

import BOJ.StreamHandlerForTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

class bj3613Test {

    private StreamHandlerForTest handler;

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void test(String input, String output) throws Exception {
        // given
        handler = new StreamHandlerForTest(input);

        // when
        bj3613.main(new String[]{}); // 테스트 실행

        // then
        assertEquals(output, handler.get());
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("toCpp", "to_cpp"),
                Arguments.of("cpp_to_java", "cppToJava"),
                Arguments.of("Error", "Error!"),
                Arguments.of("name", "name"),
                Arguments.of("bAEKJOON", "b_a_e_k_j_o_o_n"),
                Arguments.of("b_a_e_k_j_o_o_n", "bAEKJOON"),
                Arguments.of("mA_in", "Error!"),
                Arguments.of("_is_error", "Error!"),
                Arguments.of("is_error_", "Error!"),
                Arguments.of("what__if", "Error!")
        );
    }
}