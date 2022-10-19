package com.javacore.java8_introduction.Debug_Steam_Pipeline;

import com.javacore.java8_introduction.example.Employee;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.Test;

/*
    https://novemberfall.github.io/Java-ObjectOriented/#/java8/debug
 */
public class StreamDebuggingSession {
    @Test
    void testStreamDebugging() {
        List<String> names = EmployeeDatabase.getEmployees()
                .stream()
                .filter(employee -> employee.getSalary() > 40000)
                .map(Employee::getName)
//                .distinct()
                .sorted()
                .skip(0)
//                .limit(3)
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
