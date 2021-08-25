package geektrust.marketplace;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void shouldExecuteMain() throws IOException {
        Path commandsFile = Paths.get("src", "test", "resources", "commands");
        Main.main(new String[]{commandsFile.toFile().getAbsolutePath()});
        assertEquals("C-Cave\n" +
                "D-Tower\n" +
                "G-Mansion\n" +
                "NO_VACANT_ROOM\n", outContent.toString());
        assertEquals("", errContent.toString());
    }

}