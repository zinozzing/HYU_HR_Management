package org.hyhr.domain.receipts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReceiptsRepositoryTest {
    // TODO blank ReceiptsRepositoryTest
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

        receiptsRepository.save(Receipts.builder()
                .title(title)
                .uploader(uploader)
                .build());
        // when
        List<Receipts> receiptsList = receiptsRepository.findAll();

        // then
        Receipts receipts = receiptsList.get(0);
        Assertions.assertThat(receipts.getTitle()).isEqualTo(title);
        Assertions.assertThat(receipts.getUploader()).isEqualTo(uploader);
    }
}
