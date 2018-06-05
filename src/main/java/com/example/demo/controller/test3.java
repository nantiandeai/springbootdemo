package com.example.demo.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

public class test3 {
    public static void main(String[] args) {
        File userDir = new File(System.getProperty("user.dir"));
        System.out.println(Arrays.toString(userDir.list()));

        List<String> list = Arrays.asList("1", "2");
        Stream.of(list).forEach(strings -> println("nihao:"+strings));
        Stream.of(list).forEach(strings -> System.out.println(strings));
        for (String s : list) {
            System.out.println(s);
        }


    }
}
