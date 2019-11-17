package com.github.modullo11.stes.domain;

public class TokenResponse {
    private boolean active;
    private String sub;
    private String scope;

    public TokenResponse(boolean active, String sub, String scope) {
        this.active = active;
        this.sub = sub;
        this.scope = scope;
    }

    public boolean isActive() {
        return active;
    }

    public String getSub() {
        return sub;
    }

    public String getScope() {
        return scope;
    }

    public static TokenResponse fromToken(Token token) {
        return new TokenResponse(token.isActive(), token.getSub(), token.getScope());
    }
}
