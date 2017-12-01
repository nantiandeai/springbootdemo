package com.example.demo.controller;

import com.example.demo.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

    /*public void cc() throws IOException, COSVisitorException {
        PDDocument document = load("E:\\test\\pdfbox\\a0-a4.pdf");
        PDPage page = getPage(document, 4);

        PDPageContentStream contentStream = new PDPageContentStream(document, page, true, true);
        contentStream.beginText();
        contentStream.setFont(PDTrueTypeFont.loadTTF(document, "C:\\Windows\\Fonts\\SIMYOU.TTF"), 10);
        contentStream.moveTextPositionByAmount(100, 85);
        contentStream.drawString("中文");
        contentStream.endText();
        contentStream.close();

        document.save("E:\\test\\pdfbox\\a0-a4-sign.pdf");
        document.close();
    }*/

    public static void main(String[] args) {
        /*Map<String,String> map = new HashMap<String,String>();
        map.put("apple", "新鲜的苹果"); // 向列表中添加数据
        map.put("computer", "配置优良的计算机"); // 向列表中添加数据
        map.put("book", null); // 向列表中添加数据
        String key = "新鲜的苹果";
        boolean contains = map.containsKey(key);
        if (contains) {
            System.out.println("在Map集合中包含键名" + key);
        } else {
            System.out.println("在Map集合中不包含键名" + key);
        }
        boolean c = map.containsValue("新的苹果");
        System.out.println(c);*/

        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        /*for (Object feature : features) {
            System.out.println(feature);
        }*/

        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("测试1");
        user.setAge(1);
        users.add(user);
        User user1 = new User();
        user1.setName("测试2");
        user1.setAge(1);
        users.add(user1);

        users.forEach(user2 -> user1.getName().equals("测试1"));
        System.out.println();

    }


}
