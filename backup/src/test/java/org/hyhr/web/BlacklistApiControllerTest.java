package org.hyhr.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.hyhr.domain.blacklist.BlacklistRepository;
import org.hyhr.web.dto.BlacklistSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class BlacklistApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private BlacklistRepository blacklistRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @AfterEach
    public void cleanUp() throws Exception{
        blacklistRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "MANAGER")
    public void blacklist_save_and_search() throws Exception{
        // given
        String name = "name";
        String explanation = "He is a human";

        BlacklistSaveRequestDto requestDto = BlacklistSaveRequestDto.builder()
                .name(name)
                .explanation(explanation)
                .build();
        String postUrl = "http://localhost:" + port + "/api/v1/blacklist-save";
        String getUrl = "http://localhost:" + port + "/api/v1/blacklist/" + name;

        String expectedExplanation = "{\"explanation\":\"He is a human\"}";
        // when
        mvc.perform(post(postUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                        .andExpect(status().isOk());

        // then
        MvcResult result = mvc.perform(get(getUrl))
                        .andReturn();
        Assertions.assertThat(result.getResponse().getContentAsString()).isEqualTo(expectedExplanation);

    }
}
