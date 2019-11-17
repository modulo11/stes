package com.github.modullo11.stes.model;

import com.github.modullo11.stes.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, String> {
    boolean existsBySub(String sub);
}
