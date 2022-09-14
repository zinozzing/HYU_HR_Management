package org.hyhr.web;

import org.assertj.core.api.Assertions;
import org.hyhr.domain.receipts.Receipts;
import org.hyhr.domain.receipts.ReceiptsRepository;
import org.hyhr.web.dto.ReceiptsSaveRequestDto;
import org.hyhr.web.dto.ReceiptsUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ReceiptsApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ReceiptsRepository receiptsRepository;

    @AfterEach
    public void cleanUp() throws Exception{
        receiptsRepository.deleteAll();
    }

    @Test
    public void receipts_save() throws Exception{
        // given
        String title = "title";
        String uploader = "abc@de.com";
        ReceiptsSaveRequestDto requestDto = ReceiptsSaveRequestDto.builder()
                .title(title)
                .uploader(uploader)
                .build();
        String url = "http://localhost:" + port + "/api/v1/receipt-save";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Receipts> all = receiptsRepository.findAll();
        Assertions.assertThat(all.get(0).getTitle()).isEqualTo(title);
        Assertions.assertThat(all.get(0).getUploader()).isEqualTo(uploader);
    }

    @Test
    public void receipts_edit() throws Exception{
        // given
        Receipts savedReceipts = receiptsRepository.save(Receipts.builder()
                .title("receipt01")
                .uploader("abc@de.com")
                .build());

        Long updateId = savedReceipts.getId();
        String expectedTitle = "receipt02";
        String expectedUploader = "fgh@ij.com";

        ReceiptsUpdateRequestDto requestDto = ReceiptsUpdateRequestDto.builder()
                .title(expectedTitle)
                .uploader(expectedUploader)
                .build();

        String url = "http://localhost:" + port + "/api/v1/receipts/" + updateId;

        HttpEntity<ReceiptsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Receipts> all = receiptsRepository.findAll();
        Assertions.assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        Assertions.assertThat(all.get(0).getUploader()).isEqualTo(expectedUploader);
    }
}
