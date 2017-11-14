package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class pdfController {
    static String filePath = "E:\\pdf\\20170110基层公共数字文化服务推广项目实施要点.pdf";
    static String outputFilePath = "E:\\pdf\\java\\java";

    /**
     * 将输入的PDF文件转换为图片
     * @param inputFile 输入的PDF文件
     * @param outputFolder 图片输出目录
     * @throws IOException
     */
    public static List change(File inputFile, File outputFolder) throws IOException {

        PDDocument doc = null;
        String id = UUID.randomUUID().toString().replaceAll("-","");
        LinkedList<String> list = new LinkedList<>();
        try {
            doc = PDDocument.load(inputFile);
            List<PDPage> allPages = doc.getDocumentCatalog().getAllPages();
            for (int i = 0; i < allPages.size(); i++) {
                PDPage page = allPages.get(i);
                page.convertToImage();
                BufferedImage image = page.convertToImage();
                File file = new File(outputFolder.getAbsolutePath() + File.separator + (UUID.randomUUID().toString().replaceAll("-","")) + ".png");
                ImageIO.write(image, "png", file);
                String str = String.valueOf(file);
                list.add(str);

                System.out.println(str);
            }
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int idx = pdfController.filePath.lastIndexOf(".");
        String suffix = "";
        if(idx > -1){
            suffix = pdfController.filePath.substring(idx);
        }
        if(!".pdf".equals(suffix)){

        }
        File inputFile = new File(pdfController.filePath);
        File outputFolder = new File(pdfController.outputFilePath);
        if(!outputFolder.exists()){
            outputFolder.mkdirs();
        }
        try {
            pdfController.change(inputFile, outputFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
