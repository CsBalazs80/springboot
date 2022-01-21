package com.demo.repository;

import com.demo.model.Client;
import com.demo.persistence.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private ClientRepository userRepository;

    @Test
    void nonEmptyTest(){
        assertThat(userRepository).isNotNull();
    }

    @Test
    @Sql("createUser.sql")
    void readCheck(){
        //Given SQL ran
        //When
        List<Client> users = userRepository.getUserByName("Sandokan");
        //Then
        assertThat(users).isNotEmpty();
        assertThat(users.get(0)).isNotNull();
        assertThat(users.get(0).getEmail()).isEqualTo("sandokan@malay.com");
    }


    @Test
    @Sql("createUser.sql")
    void modifyCheck(){
        //Given SQL ran
        //When
        Client user = userRepository.findById(1L).orElse(null);
        assertThat(user).isNotNull();

        user.setEmail("sandokan@america.com");
        userRepository.save(user);
        //Then
        assertThat(user).isNotNull();
        assertThat(user.getEmail()).isEqualTo("sandokan@america.com");
    }



}
