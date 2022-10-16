package com.example.spring.createFiles;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.testng.annotations.Test;

public class CreateFile {

    /*
    try-catch-resource 这种方法，可以把resource 写在() 内，
        1。 public abstract class Writer implements Appendable, Closeable, Flushable
            - 可以看到 writer implements Closeable
    */
    @Test
    void testCreateFile1() {
        String fileName = "/Users/Git/Spring/src/main/java/com/example/spring/createFiles/newFile.txt";
        Path path = Paths.get(fileName);

        //to create a new file by newBufferedWriter
        //to use try-catch-resources auto close stream, don't need manually close
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write("to create a new file by newBufferedWriter");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer =
                     Files.newBufferedWriter(path,
                             StandardCharsets.UTF_8,
                             StandardOpenOption.APPEND)) {
            writer.write("\nAppend str");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
