package com.demo.service;

import com.demo.dto.UserDTO;
import com.demo.model.User;
import com.demo.persistence.UserRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    public void init(){
        userRepository = createUserRepository();
    }

    @Test
    void getByFullNameTest() {
        //given
        init();
        String name = "Bruce Lee";
        //when
        List<UserDTO> list = userService.getUserByFullName(name);
        //Then - TODO
        //assertThat(list).isNotEmpty();
        //assertThat(list.get(0)).isNotNull();
        //assertThat(list.get(0).getProfessionalEmail()).isEqualTo("notinvented@yet.com");
    }

    private UserRepository createUserRepository() {
        UserRepository mock = mock(UserRepository.class);
        String name = "Bruce Lee";
        when(mock.getUserByName(name)).thenReturn(Lists.newArrayList(User.builder().name(name).id(1L).email("a@a.a").build()));
        return mock;
    }
}
