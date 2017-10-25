package com.example.demo.controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/24.
 */
public class HelloControllerTest {
    @Test
    public void sayHello() throws Exception {
        assertEquals("hello",new HelloController().sayHello());
    }

}