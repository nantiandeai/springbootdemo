package com.example.demo.ceshi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ueditor")
public class UEditorController {

    /**
     * UEditor 入口
     *
     * @return
     */
    @RequestMapping("/controller")
    public String controller() {
        return "common/_ueditor";
    }
}

