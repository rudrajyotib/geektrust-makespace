package geektrust.marketplace.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileBasedSequentialCommandProcessorTest {

    @Test
    public void shouldProcessFile() throws IOException {
        Path commandsFile = Paths.get("src", "test", "resources", "commands");
        FileBasedSequentialCommandProcessor fileBasedSequentialCommandProcessor
                = new FileBasedSequentialCommandProcessor(commandsFile.toFile().getAbsolutePath());
        List<String> result = fileBasedSequentialCommandProcessor.processFileCommand();
        assertEquals(4, result.size());
        assertArrayEquals(new String[]{"C-Cave", "D-Tower", "G-Mansion", "NO_VACANT_ROOM"}, result.toArray(new String[0]));
    }

    @Test
    public void shouldReportFileNotFound() {
        FileBasedSequentialCommandProcessor fileBasedSequentialCommandProcessor
                = new FileBasedSequentialCommandProcessor("Gibberish path");
        assertThrows(IllegalArgumentException.class, fileBasedSequentialCommandProcessor::processFileCommand);
    }

    @Test
    public void shouldReportIfCommandFileIsDirectory() {
        Path commandsFile = Paths.get("src", "test", "resources");
        FileBasedSequentialCommandProcessor fileBasedSequentialCommandProcessor
                = new FileBasedSequentialCommandProcessor(commandsFile.toFile().getAbsolutePath());
        assertThrows(IllegalArgumentException.class, fileBasedSequentialCommandProcessor::processFileCommand);
    }

}