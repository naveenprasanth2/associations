package com.bharath.springdata.associations.testing;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestSubstring {
    public static void main(String[] args) {
        String a = "abcabcbb";
        List<String> test = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            for (int j = i + 1; j < a.length(); j++) {
                test.add(a.substring(i, j));
            }
        }
        List<String> result = new ArrayList<>();
        for (String s : test) {
           Map<String, Long> valesMap = Stream.of(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
           if (valesMap.entrySet().stream().noneMatch(e -> e.getValue() > 1)) {
               result.add(s);
           }

        }
        result.stream().sorted((x, y) -> y.length() - x.length()).findFirst().ifPresent(System.out::println);
    }
}
