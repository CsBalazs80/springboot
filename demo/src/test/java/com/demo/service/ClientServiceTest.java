package com.demo.service;

import com.demo.dto.ClientDTO;
import com.demo.model.Client;
import com.demo.persistence.ClientRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

    @Autowired
    ClientService userService;

    @MockBean
    ClientRepository userRepository;

    public void init(){
        userRepository = createUserRepository();
    }

    @Test
    void getByFullNameTest() {
        //given
        init();
        String name = "Bruce Lee";
        //when
        List<ClientDTO> list = userService.getUserByFullName(name);
        //Then - TODO
        //assertThat(list).isNotEmpty();
        //assertThat(list.get(0)).isNotNull();
        //assertThat(list.get(0).getProfessionalEmail()).isEqualTo("notinvented@yet.com");
    }

    private ClientRepository createUserRepository() {
        ClientRepository mock = mock(ClientRepository.class);
        String name = "Bruce Lee";
        when(mock.getUserByName(name)).thenReturn(Lists.newArrayList(Client.builder().name(name).id(1L).email("a@a.a").build()));
        return mock;
    }
}
