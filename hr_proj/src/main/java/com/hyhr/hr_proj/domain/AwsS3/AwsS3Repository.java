package com.hyhr.hr_proj.domain.AwsS3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class AwsS3Repository {
    private AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Autowired
    public AwsS3Repository(AmazonS3 amazonS3){
        this.amazonS3 = amazonS3;
    }

    public String upload(MultipartFile file, String prefix) throws IOException{
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
        String s3FileName = prefix + "-" + date.format(new Date()) + "-" + file.getOriginalFilename();
        String s3Location = bucket + "/" + prefix;

        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentLength(file.getInputStream().available());

        amazonS3.putObject(new PutObjectRequest(s3Location, s3FileName, file.getInputStream(), objMeta));

        return amazonS3.getUrl(s3Location, s3FileName).toString();
    }

//    public String delete(String s3Key){
//        amazonS3.deleteObject(bucket, s3Key);
//        return s3Key;
//    }
}
