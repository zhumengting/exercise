package com.zmt.exercise.util;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;

public class HTTPUtil {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        readExcel("");
    }

    public static void readExcel(String filePath) {
        String excelFileName = "C:\\Users\\zmt\\Documents\\WeChat Files\\zmt6117\\FileStorage\\File\\2020-07\\test.xlsx";
        // 读取Excel文件内容
        List<ExcelDataVo> readResult = ExcelReader.readExcel(excelFileName);

        for (int i = 0; i < readResult.size(); i++) {
            ContentType type = getContentType(readResult.get(i).filePath.substring(readResult.get(i).filePath.lastIndexOf('.')));
            String features = readResult.get(i).features.replaceAll("<strong>",",")
                    .replaceAll("<\\\\/strong>",",")
                    .replaceAll(" - ",",")
                    .replaceAll(" ",",")
                    .replaceAll("_",",")
                    .replaceAll("-",",")
                    .replaceAll(";",",")
                    .replaceAll(",,",",");
            if(features.length() > 0 && features.charAt(0) == ','){
                features = features.substring(1);
            }
            if(features.length() > 0 && features.charAt(features.length()-1) == ','){
                features = features.substring(0,features.length()-1);
            }
            System.out.println(features);
        }
    }

    public static void upload(String filePath, String feature, ContentType type) throws IOException {

        String sURL = "http://129.204.209.166:8102/resource/v2/upload";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost(sURL);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("userName", "zhumengting", ContentType.TEXT_PLAIN);
        builder.addTextBody("feature", feature, ContentType.TEXT_PLAIN);

        // 把文件加到HTTP的post请求中
        File f = new File(filePath);
        builder.addBinaryBody(
                "file",
                new FileInputStream(f),
                type,
                f.getName()
        );

        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);
        HttpEntity responseEntity = response.getEntity();
        String sResponse = EntityUtils.toString(responseEntity, "UTF-8");
        System.out.println("Post 返回结果" + sResponse);
    }

    public static ContentType getContentType(String suffix) {
        switch (suffix) {
            case ".png":
                return ContentType.IMAGE_PNG;
            case ".jpeg":
            case ".jpg":
                return ContentType.IMAGE_JPEG;
            case ".docx":
            case ".doc":
            case ".pdf":
                return ContentType.TEXT_PLAIN;
            case ".ppt":
            case ".pptx":
            case ".avi":
            case ".mp4":
            case ".mp3":
                return ContentType.APPLICATION_OCTET_STREAM;
        }
        return ContentType.DEFAULT_BINARY;
    }

}
