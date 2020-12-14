package com.electricaldiagram.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @description: 文件服务工具
 * @author: Zhaokl
 * @create: 2020-12-11 17:23
 **/
public class FileServiceUtil {

    public static void putPhotos(String photoName) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-huhehaote.aliyuncs.com";
        String accessKeyId = "LTAI4GDMjM8kLV9wrC8JwNUZ";
        String accessKeySecret = "fK3VpFTnoJZMVdAYut5wTXcTUxD2fs";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象。
        String content = photoName;
        File photo = new File("D:\\work\\javaWorkSapce\\ElectricalDiagramServer\\src\\main\\java\\com\\electricaldiagram\\util\\boxChange.png");
        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        PutObjectRequest putObjectRequest = null;
        try {
            putObjectRequest = new PutObjectRequest("zkl-photos", photoName, new FileInputStream(photo));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);

        // 上传字符串。
        PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
        System.out.println(putObjectResult);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

}
