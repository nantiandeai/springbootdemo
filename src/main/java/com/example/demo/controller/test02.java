package com.example.demo.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test02 {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        String b = map.getOrDefault(5, null);
        map.put(4, b);
        map.forEach((i, s) ->{if(i==2){
            System.out.println(s);
        }
        } );
        map.entrySet();
        Set set = map.keySet();

        for (Map.Entry<Integer, String> entry : map.entrySet()){

        }
        map.replaceAll((key, value) -> (key + 4) + value);
        map.values();
        Iterator i = set.iterator();
        System.out.println(map.entrySet());

        map.remove(1);
        map.values().forEach(System.out::println);

    }
}
