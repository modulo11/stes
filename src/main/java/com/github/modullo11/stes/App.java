package com.github.modullo11.stes;

import com.github.modullo11.stes.domain.Token;
import com.github.modullo11.stes.model.TokenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demo(TokenRepository repository) {
        return (args) -> {
            Token token = new Token();
            token.setActive(true);
            token.setScope("test:read");
            token.setSub("alice@example.com");
            token.setToken("417fb306-5948-4621-a69f-35ec4cad8526");
            repository.save(token);
        };
    }

}
