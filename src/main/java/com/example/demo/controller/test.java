package com.example.demo.controller;

import com.example.demo.domain.User;

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



}
