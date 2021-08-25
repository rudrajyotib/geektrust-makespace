package geektrust.makespace;

import geektrust.makespace.api.FileBasedSequentialCommandProcessor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileBasedSequentialCommandProcessor fileBasedSequentialCommandProcessor
                = new FileBasedSequentialCommandProcessor(args[0]);
        fileBasedSequentialCommandProcessor
                .processFileCommand()
                .forEach(System.out::println);
    }
}
