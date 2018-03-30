package com.example.demo.ueditorupload;

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
public class UeditorController {

    @RequestMapping("index")
    @ResponseBody
    @CrossOrigin
    public void showUeditor(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String rootPath = req.getRealPath("/") ;
        res.setHeader("X-Frame-Options", "SAMEORIGIN");
        String actionEnter = new ActionEnter(req,rootPath).exec() ;
        res.getWriter().write(actionEnter);
    }

}
