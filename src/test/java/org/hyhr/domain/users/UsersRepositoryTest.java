package org.hyhr.domain.users;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsersRepositoryTest {
    // TODO blank UserRepositoryTest
    @Autowired
    UsersRepository usersRepository;

    @AfterAll
    public void cleanup(){
        usersRepository.deleteAll();
    }

    @Test
    public void usersSaveAndLoad(){
        // given
        String email = "abc@cd.com";
        String authority = "WebManager";
        LocalDate signUpDate = LocalDate.parse("2022-09-13");

        usersRepository.save(Users.builder()
                .email(email)
                .authority(authority)
                .signUpDate(signUpDate)
                .build());
        // when
        List<Users> usersList = usersRepository.findAll();

        // then
        Users users = usersList.get(0);
        Assertions.assertThat(users.getEmail()).isEqualTo(email);
        Assertions.assertThat(users.getAuthority()).isEqualTo(authority);
        Assertions.assertThat(users.getSignUpDate()).isEqualTo(signUpDate);
    }

    @Test
    public void BaseTimeEntityEnrollment(){
        // given
        LocalDateTime now = LocalDateTime.parse("2022-09-14 11:45:00.000", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        usersRepository.save(Users.builder()
                .email("abc@de.com")
                .authority("MEMBER")
                .signUpDate(LocalDate.parse("2022-09-14"))
                .build());

        // when
        List<Users> usersList = usersRepository.findAll();

        // then
        Users users = usersList.get(0);

        System.out.println(">>>>>>>> createdDate="+users.getCreatedDate()+", modifiedDate="+users.getModifiedDate());

        Assertions.assertThat(users.getCreatedDate()).isAfter(now);
        Assertions.assertThat(users.getModifiedDate()).isAfter(now);
    }
}
