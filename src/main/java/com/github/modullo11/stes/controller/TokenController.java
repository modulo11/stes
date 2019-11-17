package com.github.modullo11.stes.controller;

import com.github.modullo11.stes.domain.Token;
import com.github.modullo11.stes.domain.TokenResponse;
import com.github.modullo11.stes.model.TokenRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class TokenController {

    private final TokenRepository tokenRepository;

    public TokenController(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @PostMapping("/token")
    public TokenResponse createToken(@AuthenticationPrincipal Jwt jwt) {
        // Check for expired token?
        String sub = jwt.getClaimAsString("sub");
        if (tokenRepository.existsBySub(sub)) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Token already exists");
        }

        Token token = new Token();
        token.setToken(UUID.randomUUID().toString());
        token.setSub(sub);
        token.setActive(true);

        String scope = jwt.getClaimAsStringList("scope").stream().collect(Collectors.joining(" "));
        token.setScope(scope);

        tokenRepository.save(token);

        return TokenResponse.fromToken(token);
    }

    @DeleteMapping("/token/{id}")
    public void deleteToken(String id) {
        tokenRepository.deleteById(id);
    }
}
