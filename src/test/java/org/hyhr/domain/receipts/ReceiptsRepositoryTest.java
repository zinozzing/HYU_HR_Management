package org.hyhr.domain.receipts;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ReceiptsRepositoryTest {
    // TODO blank ReceiptsRepositoryTest
    @Autowired
    ReceiptsRepository receiptsRepository;

    @AfterAll
    public void cleanup(){
        receiptsRepository.deleteAll();
    }

    @Test
    public void receiptsSaveAndLoad(){
        // given


        // when


        // then
    }
}
