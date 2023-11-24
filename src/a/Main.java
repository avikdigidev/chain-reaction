/*
package a;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static String findTopIpaddress(String[] lines) {
        Map<String, Long> ipCounts = Arrays.stream(lines)
                .map(line -> line.split(" - ")[0])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return ipCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static void main(String[] args) {
        String lines[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132" };
        String result = findTopIpaddress(lines);

        if ("10.0.0.1".equals(result)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}



class User {
    static {
        System.out.println("1");
    }
    public User() {
        System.out.println("2");
    }
}



class Manager extends User {
    static {
        System.out.println("3");
    }
    public Manager() {
        System.out.println("4");
    }
}



*/
