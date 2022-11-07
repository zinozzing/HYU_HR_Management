package com.hyhr.hr_proj.domain.receipts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReceiptsRepositoryTest {
    @Autowired
    ReceiptsRepository receiptsRepository;

    @AfterAll
    public  void cleanup(){
        receiptsRepository.deleteAll();
    }

    @Test
    public void receiptsSaveAndLoad(){
        // given
        String title = "receipt01";
        String uploader = "abc@cd.com";
        String testUrl = "http://www.abcde.com/1234.zip";

        receiptsRepository.save(Receipts.builder()
                .title(title)
                .uploader(uploader)
                .url(testUrl)
                .build());
        // when
        List<Receipts> receiptsList = receiptsRepository.findAll();

        // then
        Receipts receipts = receiptsList.get(0);
        Assertions.assertThat(receipts.getTitle()).isEqualTo(title);
        Assertions.assertThat(receipts.getUploader()).isEqualTo(uploader);
        Assertions.assertThat(receipts.getUrl()).isEqualTo(testUrl);
    }

    @Test
    public void BaseTimeEntityEnrollment(){
        // given
        LocalDateTime now = LocalDateTime.parse("2022-09-14 11:45:00.000", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        receiptsRepository.save(Receipts.builder()
                .title("title")
                .uploader("abc@de.com")
                .url("http://www.abcde.com/1234.zip")
                .build());

        // when
        List<Receipts> receiptsList = receiptsRepository.findAll();

        // then
        Receipts receipts = receiptsList.get(0);

        System.out.println(">>>>>>>> createdDate="+receipts.getCreatedDate()+", modifiedDate="+receipts.getModifiedDate());

        Assertions.assertThat(receipts.getCreatedDate()).isAfter(now);
        Assertions.assertThat(receipts.getModifiedDate()).isAfter(now);
    }
}
