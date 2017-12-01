package com.example.demo.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@Controller()
@RequestMapping("/ueditor")
@CrossOrigin
public class UeditorController {

    @RequestMapping("index")
    @ResponseBody
    public void showUeditor(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String rootPath = req.getRealPath("/") ;
        String actionEnter = new ActionEnter(req,rootPath).exec() ;
        res.getWriter().write(actionEnter);
    }

}
