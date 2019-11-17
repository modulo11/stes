package com.github.modullo11.stes.controller;

import com.github.modullo11.stes.domain.Token;
import com.github.modullo11.stes.model.TokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    private final TokenRepository tokenRepository;

    public DebugController(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @GetMapping("/debug/token")
    public Iterable<Token> getAllTokens() {
        return tokenRepository.findAll();
    }
}
