package org.hyhr.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsersRepositoryTest {
    // TODO blank UserRepositoryTest
    @Autowired
    UserRepository userRepository;

    @AfterAll
    public void cleanup(){
        userRepository.deleteAll();
    }

    @Test
    public void usersSaveAndLoad(){
        // given
        String email = "abc@cd.com";
        String authority = "WebManager";
        LocalDate signUpDate = LocalDate.parse("2022-09-13");

        userRepository.save(Users.builder()
                .email(email)
                .authority(authority)
                .signUpDate(signUpDate)
                .build());
        // when
        List<Users> usersList = userRepository.findAll();

        // then
        Users users = usersList.get(0);
        Assertions.assertThat(users.getEmail()).isEqualTo(email);
        Assertions.assertThat(users.getAuthority()).isEqualTo(authority);
        Assertions.assertThat(users.getSignUpDate()).isEqualTo(signUpDate);
    }
}
