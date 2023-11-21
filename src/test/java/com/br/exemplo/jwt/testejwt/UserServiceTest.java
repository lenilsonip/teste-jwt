package com.br.exemplo.jwt.testejwt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.exemplo.jwt.testejwt.entity.User;
import com.br.exemplo.jwt.testejwt.repository.UserRepository;
import com.br.exemplo.jwt.testejwt.service.UserService;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetAllUsers() {
        // Configurar o comportamento do mock
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");
        user1.setPassword("password1");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setPassword("password2");

        List<User> userList = Arrays.asList(user1, user2);

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        // Chamar o método a ser testado
        List<User> result = userService.getAllUsers();

        // Verificar se o método retorna a lista esperada
        Assertions.assertEquals(userList, result);
    }
}
