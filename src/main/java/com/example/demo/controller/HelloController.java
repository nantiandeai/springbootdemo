package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 *
 * @author frank
 */
@Controller
public class HelloController {
    @Value("${com.didispace.blog.name}")
    private String name;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", name);
        return "/index";
    }

    /**
     * 跳转
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

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        String str = "[{\"timestart\":\"2017-10-27 14:19:44\",\"timeend\":\"2017-10-28 14:19:49\"},{\"timestart\":\"2017-10-29 14:20:01\",\"timeend\":\"2017-10-30 14:20:05\"}]";
        JSONArray timesArray = JSON.parseArray(str);
        System.out.println(JSON.toJSON(timesArray));
        System.out.println(str);
        JSONArray jsonArray=JSONArray.parseArray(str);
        for (int i = 0; i < timesArray.size(); i++) {
            JSONObject json = (JSONObject) timesArray.get(i);
            System.out.println(json.get("timeend"));
        }


        String json = "[{\"name\":\"xuliugen\",\"sex\":\"nan\"},{\"name\":\"xieyan\",\"sex\":\"nv\"}]";
        JSONArray jsonArray1 = JSON.parseArray(json);
        String str1 = jsonArray1.getString(0);
        User jsonTest = JSON.parseObject(str1,User.class);
        System.out.println(jsonTest.getName());
        for (Object o : timesArray) {
            JSONObject jsonObject = (JSONObject) o;
            try {
                date = sdf.parse((String) jsonObject.get("timeend"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date);
        }


        List<User> list = new ArrayList<>();
        for (User user : list) {

        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
    }

}
