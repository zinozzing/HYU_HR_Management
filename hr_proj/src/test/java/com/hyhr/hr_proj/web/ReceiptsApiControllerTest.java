package com.hyhr.hr_proj.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.findify.s3mock.S3Mock;
import org.assertj.core.api.Assertions;
import com.hyhr.hr_proj.domain.receipts.Receipts;
import com.hyhr.hr_proj.domain.receipts.ReceiptsRepository;
import com.hyhr.hr_proj.web.dto.ReceiptsSaveRequestDto;
import com.hyhr.hr_proj.web.dto.ReceiptsUpdateRequestDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@Import(S3Mock.class)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//public class ReceiptsApiControllerTest {
//    @Autowired
//    private ReceiptsApiController receiptsApiController;
//
//    @Autowired
//    private ReceiptsRepository receiptsRepository;
//
//    @Autowired
//    S3Mock s3Mock;
//
//    @AfterAll
//    public void cleanUp() throws Exception{
//        s3Mock.stop();
//    }
//
//    @Test
//    @WithMockUser(roles = "MANAGER")
//    public void receipts_save() throws Exception{
//        // given
//        String title = "title";
//        String uploader = "abc@de.com";
//        String expectedUrl = "mock1.png"
//        String testUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Amber_Mountain_chameleon_(Calumma_amber)_male_Montagne_d%E2%80%99Ambre_2.jpg/120px-Amber_Mountain_chameleon_(Calumma_amber)_male_Montagne_d%E2%80%99Ambre_2.jpg";
//        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", expectedUrl, "image/png", "test data".getBytes());
//
////        String url = "http://localhost:" + port + "/api/vq/receipt-save";
//        receiptsApiController.save(title, uploader, file);
//
//
//    }
//}

//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//public class ReceiptsApiControllerTest {
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private ReceiptsRepository receiptsRepository;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mvc;
//
//    @BeforeEach
//    public void setup(){
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }
//
//    @AfterEach
//    public void cleanUp() throws Exception{
//        receiptsRepository.deleteAll();
//    }
//
//    @Test
//    @WithMockUser(roles = "GUEST")
//    public void receipts_save() throws Exception{
//        // given
//        String title = "title";
//        String uploader = "abc@de.com";
//        String testUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Amber_Mountain_chameleon_(Calumma_amber)_male_Montagne_d%E2%80%99Ambre_2.jpg/120px-Amber_Mountain_chameleon_(Calumma_amber)_male_Montagne_d%E2%80%99Ambre_2.jpg";
////        ReceiptsSaveRequestDto requestDto = ReceiptsSaveRequestDto.builder()
////                .title(title)
////                .uploader(uploader)
////                .url(testUrl)
////                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/receipt-save";
//
//        // when
////        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
//        mvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("title", title)
//                .param("uploader", uploader)
//                .param("url", testUrl))
//                .andExpect(status().isOk());
////                        .content(new ObjectMapper().writeValueAsString(requestDto)))
//
//        // then
////        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
////        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Receipts> all = receiptsRepository.findAll();
//        Assertions.assertThat(all.get(0).getTitle()).isEqualTo(title);
//        Assertions.assertThat(all.get(0).getUploader()).isEqualTo(uploader);
//        Assertions.assertThat(all.get(0).getUrl()).isEqualTo(testUrl);
//    }
//
//    @Test
//    @WithMockUser(roles = "MEMBER")
//    public void receipts_edit() throws Exception{
//        // given
//        Receipts savedReceipts = receiptsRepository.save(Receipts.builder()
//                .title("receipt01")
//                .uploader("abc@de.com")
//                .url("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Amber_Mountain_chameleon_(Calumma_amber)_male_Montagne_d%E2%80%99Ambre_2.jpg/120px-Amber_Mountain_chameleon_(Calumma_amber)_male_Montagne_d%E2%80%99Ambre_2.jpg")
//                .build());
//
//        Long updateId = savedReceipts.getId();
//        String expectedTitle = "receipt02";
//        String expectedUploader = "fgh@ij.com";
//        String expectedUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Wild_shortbeak_echidna.jpg/120px-Wild_shortbeak_echidna.jpg";
//
//        ReceiptsUpdateRequestDto requestDto = ReceiptsUpdateRequestDto.builder()
//                .title(expectedTitle)
//                .uploader(expectedUploader)
//                .url(expectedUrl)
//                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/receipts/" + updateId;
//
//        HttpEntity<ReceiptsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
//
//        // when
////        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class)
//        mvc.perform(put(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(requestDto)))
//                .andExpect(status().isOk());
//
//        // then
////        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
////        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);
//        List<Receipts> all = receiptsRepository.findAll();
//        Assertions.assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
//        Assertions.assertThat(all.get(0).getUploader()).isEqualTo(expectedUploader);
//        Assertions.assertThat(all.get(0).getUrl()).isEqualTo(expectedUrl);
//    }
//}
