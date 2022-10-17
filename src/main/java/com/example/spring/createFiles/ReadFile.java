package com.example.spring.createFiles;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {

    @Test
    void testReadFile() throws FileNotFoundException {
        String fileName = "C:\\Users\\Git\\GitHub\\Spring\\src\\main\\java\\com\\example\\spring\\createFiles\\newFile.txt";

        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }

        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            scanner.useDelimiter("\\|"); //分隔符
            while (scanner.hasNext()) {
                String str = scanner.next();
                System.out.println(str);
            }
        }

        fileName = "C:\\Users\\Git\\GitHub\\Spring\\src\\main\\java\\com\\example\\spring\\createFiles\\file5.txt";
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            sc.useDelimiter("\\|");
            while (sc.hasNextInt()) {
                int intValue = sc.nextInt();
                System.out.println(intValue);
            }
        }
    }

    /*
    用stream的好处是：不用一次性把文件内容加载到内存里，内存消耗更小，
     */
    @Test
    void testReadFile2() throws IOException {
        String fileName = "C:\\Users\\Git\\GitHub\\Spring\\src\\main\\java\\com\\example\\spring\\createFiles\\newFile.txt";

        // 读取文件中的内容到stream中，按行读取
        Stream<String> lines = Files.lines(Paths.get(fileName));

        // stream里的数据，是不按照顺序处理的
        lines.forEach(System.out::println);


        // 按照顺序处理stream里的数据
//        lines.forEachOrdered(System.out::println);


        // 并行stream可以有效的利用cpu多核的特性，加快行的处理速度
//        lines.parallel().forEachOrdered(System.out::println);


        // convert stream to List<String>
//        List<String> collect = lines.collect(Collectors.toList());
    }





    /*
        用stream的好处是：不用一次性把文件内容加载到内存里，内存消耗更小，
    */
    @Test
    void testReadFile3() throws IOException {
        String fileName = "C:\\Users\\Git\\GitHub\\Spring\\src\\main\\java\\com\\example\\spring\\createFiles\\newFile.txt";

        List<String> lines = Files.readAllLines(Paths.get(fileName),
                StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
    }



    /*
        JDK 11 开始提供的办法，读取文件不能超过2G，与内存息息相关
    */
    @Test
    void testReadFile4() throws IOException {
        String fileName = "C:\\Users\\Git\\GitHub\\Spring\\src\\main\\java\\com\\example\\spring\\createFiles\\newFile.txt";


        String strs = Files.readString(Paths.get(fileName));
        System.out.println(strs);
    }
}













