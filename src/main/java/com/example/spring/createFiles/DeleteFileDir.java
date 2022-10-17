package com.example.spring.createFiles;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.stream.Stream;

public class DeleteFileDir {
    /*
    data
      |--test1
            |--test2
                |== test2.log
                |--test3
                    |==test3.log
                    |--test4
                        |--test5
     */
    private void createMoreFiles() throws IOException {
        Files.createDirectories(Paths.get("C:\\Users\\Git\\GitHub\\Spring\\src\\test\\test1\\test2\\test3\\test4\\test5\\"));
        Files.write(Paths.get("C:\\Users\\Git\\GitHub\\Spring\\src\\test\\test1\\test2\\test2.log"), "hello".getBytes());
        Files.write(Paths.get("C:\\Users\\Git\\GitHub\\Spring\\src\\test\\test1\\test2\\test3\\test3.log"), "hello".getBytes());
    }


    @Test
    void testDeleteFileDir5() throws IOException {
        createMoreFiles();
        Path path = Paths.get("C:\\Users\\Git\\GitHub\\Spring\\src\\test\\test1\\test2");

        Files.walkFileTree(path,
                new SimpleFileVisitor<Path>() {
                    // 先去遍历删除文件
                    @Override
                    public FileVisitResult visitFile(Path file,
                                                     BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        System.out.printf("File is deleted : %s%n", file);
                        return FileVisitResult.CONTINUE;
                    }

                    // 再去遍历删除目录
                    @Override
                    public FileVisitResult postVisitDirectory(Path dir,
                                                              IOException exception) throws IOException {
                        Files.delete(dir);
                        System.out.printf("Director is deleted : %s%n", dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
    }

    @Test
    void testDeleteFileDir6() throws IOException {
        createMoreFiles();
        Path path = Paths.get("C:\\Users\\Git\\GitHub\\Spring\\src\\test\\test1\\test2");

        try (Stream<Path> walk = Files.walk(path)) {
            walk.sorted(Comparator.reverseOrder())
                    .forEach(DeleteFileDir::deleteDirectoryStream);
        }
    }

    private static void deleteDirectoryStream(Path path) {
        try{
            Files.delete(path);
            System.out.printf("Deleted Files successfully: %s%n", path.toString());
        } catch (IOException e) {
            System.err.printf("It was not able to delete this Path %s%n%s", path, e);
        }
    }


    //传统IO 递归删除
    @Test
    void testDeleteFileDir7() throws IOException {
        createMoreFiles();
        File file = new File("C:\\Users\\Git\\GitHub\\Spring\\src\\test\\test1\\test2");
        deleteDirectoryLegacyIO(file);
    }

    private void deleteDirectoryLegacyIO(File file) {
        File[] list = file.listFiles(); // 无法做到list多层文件夹数据
        if (list != null) {
            for (File curFile : list) {
                deleteDirectoryLegacyIO(curFile); // recursive call
            }
        }

        if (file.delete()) {
            System.out.printf("Delete Successfully : %s%n", file);
        } else {
            System.out.printf("Delete Successfully : %s%n", file);
        }
    }
}



















