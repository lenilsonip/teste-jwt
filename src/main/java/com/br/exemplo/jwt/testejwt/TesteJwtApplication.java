package com.br.exemplo.jwt.testejwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.br.exemplo.jwt.testejwt.entity.User;
import com.br.exemplo.jwt.testejwt.repository.UserRepository;

@SpringBootApplication
public class TesteJwtApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(TesteJwtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Adicione lógica para criar um usuário durante a inicialização
        createUserIfNotExists("admin", "admin");
    }

    private void createUserIfNotExists(String username, String password) {
        if (!userRepository.findByUsername(username).isPresent()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        }
    }
}
