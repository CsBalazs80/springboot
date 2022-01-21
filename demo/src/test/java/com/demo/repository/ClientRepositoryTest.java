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
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void nonEmptyTest(){
        assertThat(clientRepository).isNotNull();
    }

    @Test
    @Sql("createClient.sql")
    void readCheck(){
        //Given SQL ran
        //When
        List<Client> clients = clientRepository.getClientByName("Sandokan");
        //Then
        assertThat(clients).isNotEmpty();
        assertThat(clients.get(0)).isNotNull();
        assertThat(clients.get(0).getEmail()).isEqualTo("sandokan@malay.com");
    }


    @Test
    @Sql("createClient.sql")
    void modifyCheck(){
        //Given SQL ran
        //When
        Client client = clientRepository.findById(1L).orElse(null);
        assertThat(client).isNotNull();

        client.setEmail("sandokan@america.com");
        clientRepository.save(client);
        //Then
        assertThat(client).isNotNull();
        assertThat(client.getEmail()).isEqualTo("sandokan@america.com");
    }

    // test the other methods on demand

}
