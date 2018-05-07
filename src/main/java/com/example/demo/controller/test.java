package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        user1.setName("lisi");
        user1.setAge(1);
        users.add(user1);

        int bb = 0;
        System.out.println(users.size()+bb);

        /*Optional.ofNullable(user1).map(t->t.getName()).map(String::toUpperCase);
        System.out.println(Optional.ofNullable(user1).map(t->t.getName()).map(String::toUpperCase));

        System.out.println(Optional.ofNullable(user).map(t -> t.getName()).orElse("李四"));
        users.forEach(uu->{if(uu.getName().equals("测试1")){
            System.out.println("找到你了");
        }
        });

        String nickName = getNickName("Duke").orElse("太傻了");
        System.out.println(nickName);
        Stream<String> names = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
        names
                .filter(name -> name.startsWith("L"))
                .findFirst().ifPresent(name -> {
            String s = name.toUpperCase();
            System.out.println("The longest name is " + s);
        });

        String[] array = new String[] {
                "hello",
                ", ",
                "world",
        };
        List<String> list = Arrays.asList(array);*/
        Optional.of(users).ifPresent(c -> c.forEach(b->{

            System.out.println(Optional.of("ddd".equals(b.getName())).orElse(null));
        }));

        users.sort(Comparator.comparing(User::getName));
    }


    static Optional<String> getNickName(String name) {
        Map<String, String> nickNames = new HashMap<>(); // 假裝的鍵值資料庫
        nickNames.put("Justin", "caterpillar");
        nickNames.put("Monica", "momor");
        nickNames.put("Irene", "hamimi");
        String nickName = nickNames.get(name);
        return nickName == null ? Optional.empty() : Optional.of(nickName);
    }


    public void menthod(){
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
