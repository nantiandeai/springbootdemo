package com.example.demo.controller;

import com.example.demo.domain.Resource;
import com.example.demo.utils.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/10/24.
 *
 * @author frank
 */
@Controller
public class HelloController {
    @Value("${com.didispace.blog.name}")
    private String name;

    @Autowired
    private Resource resource;

    @GetMapping(value = "/say")
    public String sayHello(HttpSession session, HttpServletRequest request) {
        /*String id = session.getId();
        System.out.println(session.getId());
        Cookie [] cookie = request.getCookies();
        for (Cookie cookie1 : cookie) {
            System.out.println(cookie1.getName());
        }
        System.out.println(Arrays.toString(cookie));*/

        return "hello";
    }

    /**
     * 主页
     * @param model 页面
     * @return index
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", name);
        return "/index";
    }

    /**
     * 跳转 重定向
     *
     * @return
     */
    @RequestMapping("/redirect")
    public String page2(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("name");
        Cookie cName = new Cookie("username",username );
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Cookie cDate = new Cookie("lastVisited",format.format(new java.util.Date()));
        System.out.println(cName.getName());
        System.out.println(cName.getValue());
        session = request.getSession();
        System.out.println(session.getId());
        session.setAttribute("name","lisi");
        System.out.println(session.getAttribute("name"));
        System.out.println(session.getServletContext());
        return "redirect/redirect";
    }

    /**
     * 视图
     *
     * @param model
     * @return
     */
    @RequestMapping("/model")
    public String page3(Model model) {
        model.addAttribute("name", "seawater");
        return "system/index";
    }

    @RequestMapping("/getResource")
    @ResponseBody
    public JSONResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return JSONResult.ok(bean);
    }

    @RequestMapping(value = "/thymeleaf")
    public String thymeleafTest(ModelMap modelMap) {
        modelMap.addAttribute("name", "frank");
        modelMap.addAttribute("user", resource);
        return "hello";
    }

}
