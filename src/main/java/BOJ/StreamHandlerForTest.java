package BOJ;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class StreamHandlerForTest {

    private ByteArrayInputStream inputStream;
    private ByteArrayOutputStream outputStream;

    public StreamHandlerForTest(String input) {
        inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        outputStream = new ByteArrayOutputStream();
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
    }

    public String get() {
        return outputStream.toString();
    }
}

