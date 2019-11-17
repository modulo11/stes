package com.github.modullo11.stes.controller;

import com.github.modullo11.stes.domain.Token;
import com.github.modullo11.stes.domain.TokenResponse;
import com.github.modullo11.stes.model.TokenRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class InspectionController {

    private final TokenRepository tokenRepository;

    public InspectionController(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @PostMapping(value = "/introspect", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public TokenResponse retrieveToken(@RequestBody final MultiValueMap<String, String> data) {
        if (!data.containsKey("token")) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        final String tokenId = data.get("token").get(0);
        final Token token = tokenRepository.findById(tokenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        return TokenResponse.fromToken(token);
    }

}
