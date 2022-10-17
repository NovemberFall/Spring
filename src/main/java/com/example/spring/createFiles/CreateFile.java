package com.example.spring.createFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
        // win
//        String fileName = "C:\\Users\\Git\\GitHub\\Spring\\src\\main\\java\\com\\example\\spring\\createFiles\\newFile.txt";
        String fileName = "/Users/Git/Spring/src/main/java/com/example/spring/createFiles/newFile.txt";

        // mac
//        String fileName = "/Users/Git/Spring/src/main/java/com/example/spring/createFiles/newFile.txt";
        Path path = Paths.get(fileName);

        //to create a new file by newBufferedWriter
        //to use try-catch-resources auto close stream, don't need manually close
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write("to create a new file by newBufferedWriter | Jim Zhang");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer =
                     Files.newBufferedWriter(path,
                             StandardCharsets.UTF_8,
                             StandardOpenOption.APPEND)) {
            writer.write("\nAppend str");
            writer.write("\nJava 8 | Stream str");
            writer.write("\nStrings");
            writer.write("\nEnd...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    From JDK 1.5
     */
    @Test
    void testCreateFile2() throws IOException {
//        String fileName = "C:\\Users\\Git\\GitHub\\Spring\\src\\main\\java\\com\\example\\spring\\createFiles\\newFile2.txt";
        String fileName = "/Users/Git/Spring/src/main/java/com/example/spring/createFiles/newFile2.txt";

        //From JDK 1.5
        try(PrintWriter writer = new PrintWriter(fileName, "UTF-8")) {
            writer.println("Hello World!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // From JAVA 10, 支持使用StandardCharacter指定字符集
        // 这种适合一行一行写入数据
        try (PrintWriter writer = new PrintWriter(fileName, String.valueOf(StandardCharsets.UTF_8))) {
            writer.println("first line");
            writer.println("second line");
        }
    }

    /*
    这种方法，只适合创建文件，搭配 FileWriter 来写入文件
     */
    @Test
    void testCreateFile3() throws IOException {
//        String fileName = "C:\\Users\\Git\\GitHub\\Spring\\src\\main\\java\\com\\example\\spring\\createFiles\\newFile3.txt";
        String fileName = "/Users/Git/Spring/src/main/java/com/example/spring/createFiles/newFile3.txt";
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("Create File3 successfully!");
        } else {
            System.out.println("Failed to create File3!");
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello World!");
        }
    }

    @Test
    void testCreateFile4() throws IOException {
//        String fileName = "C:\\Users\\Git\\GitHub\\Spring\\src\\main\\java\\com\\example\\spring\\createFiles\\newFile4.txt";
        String fileName = "/Users/Git/Spring/src/main/java/com/example/spring/createFiles/newFile4.txt";
        try (FileOutputStream fos = new FileOutputStream(fileName);
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(osw);
        ) {
            bw.write("Hello world!!!");
            bw.flush();
        }
    }
}



















