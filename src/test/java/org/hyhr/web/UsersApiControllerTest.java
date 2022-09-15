package org.hyhr.web;

import org.assertj.core.api.Assertions;
import org.hyhr.domain.users.Role;
import org.hyhr.domain.users.Users;
import org.hyhr.domain.users.UsersRepository;
import org.hyhr.web.dto.UsersSaveRequestDto;
import org.hyhr.web.dto.UsersUpdateRequestDto;
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

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class UsersApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsersRepository usersRepository;

    @AfterEach
    public void cleanUp() throws Exception{
        usersRepository.deleteAll();
    }

    @Test
    public void users_save() throws Exception{
        // given
        String email = "abc@de.com";
        LocalDate signUpDate = LocalDate.parse("2022-09-14");
        Role role = Role.MEMBER;
        UsersSaveRequestDto requestDto = UsersSaveRequestDto.builder()
                .email(email)
                .signUpDate(signUpDate)
                .role(role)
                .build();
        String url = "http://localhost:" + port + "/api/v1/user-save";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Users> all = usersRepository.findAll();
        Assertions.assertThat(all.get(0).getEmail()).isEqualTo(email);
        Assertions.assertThat(all.get(0).getRole()).isEqualTo(role);
        Assertions.assertThat(all.get(0).getSignUpDate()).isEqualTo(signUpDate);
    }

    @Test
    public void users_edit() throws Exception{
        // given
        Users savedUsers = usersRepository.save(Users.builder()
                .email("abc@de.com")
//                .authority("MEMBER")
                .signUpDate(LocalDate.parse("2022-09-14"))
                .role(Role.MEMBER)
                .build());

        Long updateId = savedUsers.getId();
        String expectedEmail = "fgh@ij.com";
        LocalDate expectedSignUpDate = LocalDate.parse("2022-10-14");
        Role expectedRole = Role.MANAGER;

        UsersUpdateRequestDto requestDto = UsersUpdateRequestDto.builder()
                .email(expectedEmail)
                .signUpDate(expectedSignUpDate)
                .role(expectedRole)
                .build();

        String url = "http://localhost:" + port + "/api/v1/users/" + updateId;

        HttpEntity<UsersUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Users> all = usersRepository.findAll();
        Assertions.assertThat(all.get(0).getEmail()).isEqualTo(expectedEmail);
        Assertions.assertThat(all.get(0).getRole()).isEqualTo(expectedRole);
        Assertions.assertThat(all.get(0).getSignUpDate()).isEqualTo(expectedSignUpDate);


    }
}
