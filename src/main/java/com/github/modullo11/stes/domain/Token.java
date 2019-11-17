package com.github.modullo11.stes.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Token {
    @Id
    private String token;
    private String sub;
    private boolean active;
    private String scope;

    public Token() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
