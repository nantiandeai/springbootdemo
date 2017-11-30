package com.example.demo.ceshi;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.xiaosuokeji.feelschool.admin.util.OssUtils;
import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.util.Map;

/**
 * Created by GustinLau on 2017-05-11.
 */
public class Base64Uploader {

    public static State save(String content, Map<String, Object> conf) {
        byte[] data = decode(content);
        long maxSize = ((Long) conf.get("maxSize")).longValue();
        if (!validSize(data, maxSize)) {
            return new BaseState(false, 1);
        } else {
            String suffix = FileType.getSuffix("JPG");
            String savePath = PathFormat.parse((String) conf.get("savePath"), (String) conf.get("filename"));
            savePath = savePath + suffix;

            //自定义处理部分
            //将byte[]转换成输入流
            ByteArrayInputStream is = new ByteArrayInputStream(data);
            //图片上传到阿里云OSS服务器，自己写的工具类
            Map result = OssUtils.ueditorUpload(is, savePath);
            //构造对应的Stage让UEditor读取
            State storageState = new BaseState((boolean) result.get("status"));
            if (storageState.isSuccess()) {
                storageState.putInfo("url", (String) result.get("url"));
                storageState.putInfo("type", suffix);
                storageState.putInfo("original", "");
            }

            return storageState;
        }
    }

    private static byte[] decode(String content) {
        return Base64.decodeBase64(content);
    }

    private static boolean validSize(byte[] data, long length) {
        return (long) data.length <= length;
    }
}

