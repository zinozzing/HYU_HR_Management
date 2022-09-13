package org.hyhr.domain.user;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {
    // TODO blank UserRepositoryTest
    @Autowired
    UserRepository userRepository;

    @AfterAll
    public void cleanup(){
        userRepository.deleteAll();
    }

    @Test
    public void userSaveAndLoad(){
        // given
        String email = "abc@cd.com";


        // when


        // then
    }
}
