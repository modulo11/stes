# Simple Token Exchange Service (STES)

This prototype can exchange and return bearer tokens for opaque tokens. It is mainly suited for [Keycloak](https://www.keycloak.org/) and (obviously) [Spring](https://spring.io/projects/spring-framework)/[Spring Security](https://spring.io/projects/spring-security).

## Use case

### First time usage

1. User logs in to some sort of website
2. Backend calls STES with the users JWT
3. STES: 
    * Extracts all relevant data (sub and scopes)
    * Generates a new (active) opaque token
    * Saves and returns the generated token
4. Opaque token can be presented to the user

### Backend call with opaque token

1. User provides opaque token in the header
2. Backend calls introspection endpoint
3. Access is permitted or denied

## API

| Method | Endpoint | Description |
|----------|--------|-------------|
|`POST`|`/introspect`|Introspection endpoint, see [RFC7662](https://tools.ietf.org/html/rfc7662)|
|`POST`|`/token`|Token exchange endpoint|
|`DELETE`|`/token`|Delete an existing token|
|`GET`|`/debug/token`|Only for debugging, returns list of all opaque tokens|

## ToDo/Ideas

* Write token back to Keycloak?
* Persistent storage
* Use [Vault](https://www.vaultproject.io/) as storage
* UI for managing tokens
* Keycloak SPI which creates opaque token on registration
