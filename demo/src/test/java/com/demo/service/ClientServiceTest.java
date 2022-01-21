package com.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Test
    void getByFullNameTest() {

        // test the service and use mock repository to return data
    }

}
