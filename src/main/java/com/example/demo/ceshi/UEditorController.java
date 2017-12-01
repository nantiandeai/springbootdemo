package com.example.demo.ceshi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/sys/ueditor")
public class UEditorController {

    @RequestMapping(value = "/exec")
    @ResponseBody
    public String exec(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String rootPath = request.getRealPath("/");
        rootPath += "STATIC\\ueditor" ;
        return new ActionEnter(request, rootPath).exec();
    }
}

