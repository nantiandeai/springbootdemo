package com.example.demo.controller;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 类说明
 * @author wangliang E-mail: liangwang@lagou.com
 * @version 0.0.1
 * @date 创建时间：2016年5月6日 下午1:46:18
 */
public class JsonTest {
    @SuppressWarnings({ "static-access", "deprecation", "unchecked" })
    public static void main(String[] args) throws UnsupportedEncodingException {
        String JsonContext = new Util().ReadFile("E:\\test\\China.json");
        JSONArray jsonArray = JSONArray.fromObject(JsonContext);
        /*String s= java.net.URLDecoder.decode(JsonContext, "utf-8");
        JSONObject jsonArray = new JSONObject();*/

        int size = jsonArray.size();
        System.out.println("Size: " + size);
        /*for(int  i = 0; i < size; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println("[" + i + "]name=" + jsonObject.get("name"));
            System.out.println("[" + i + "]package_name=" + jsonObject.get("package_name"));
            System.out.println("[" + i + "]check_version=" + jsonObject.get("check_version"));

        }*/
        List<MorphDynaBean> listObject = JSONArray.toList(jsonArray);
       /* for(int i = 0, j = listObject.size(); i < j ; i++){
            System.out.println(listObject.get(i));
        }*/
        for(MorphDynaBean temp: listObject){
            System.out.println(temp.get("ShengJiName"));
            System.out.println(temp.get("quHuaDaiMa"));
        }
    }
}
