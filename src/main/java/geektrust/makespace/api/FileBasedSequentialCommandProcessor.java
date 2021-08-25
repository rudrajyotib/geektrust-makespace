package geektrust.makespace.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileBasedSequentialCommandProcessor {

    private final String filePath;


    public FileBasedSequentialCommandProcessor(String filePath) {
        this.filePath = filePath;
    }

    public List<String> processFileCommand() throws IOException {
        File commandFile = new File(this.filePath);
        if (!commandFile.exists()) {
            throw new IllegalArgumentException("Command file does not exist.");
        }
        if (!commandFile.isFile()) {
            throw new IllegalArgumentException("Command file not found.");
        }
        try (Stream<String> commandStream = Files.lines(Paths.get(this.filePath))) {
            return commandStream
                    .map(SingleCommandProcessor::processSingleCommand)
                    .collect(Collectors.toList());
        }
    }
}
