package com.noahandsons.Boost.authorization.server.mappers;

import com.noahandsons.Boost.authorization.server.entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class Mapper {


    public static GrantTypes from (AuthorizationGrantType authorizationGrantType){
        return GrantTypes.builder()
                .grantType(authorizationGrantType.getValue())
                .build();
    }

    public static Scopes scopeFrom (String scope){
        return Scopes.builder()
                .scopes(scope)
                .build();
    }

    public static AuthenticationMethods from (ClientAuthenticationMethod authenticationMethod){
        return AuthenticationMethods.builder()
                .authenticationMethod(authenticationMethod.getValue())
                .build();
    }

    public static RedirectUrls urlFrom (String redirectUrls){
        return RedirectUrls.builder()
                .url(redirectUrls)
                .build();
    }

    public static RegisteredClient from (Client client){


        return RegisteredClient.withId(String.valueOf(client.getId()))
                .clientId(client.getClientId())
                .clientSecret(client.getSecret())
                .scopes(scopes -> scopes.addAll(client.getScopes().stream().map(Scopes::getScopes).toList()))
                .redirectUris(uris -> uris.addAll(client.getRedirectUrls().stream().map(RedirectUrls::getUrl).collect(Collectors.toSet())))
                .authorizationGrantTypes(grants -> grants.addAll(client.getGrantTypes().stream().map(grant -> new AuthorizationGrantType(grant.getGrantType().toLowerCase())).toList()))
                .clientAuthenticationMethods(authentications -> authentications.addAll(client.getAuthenticationMethods().stream().map(authentication -> new ClientAuthenticationMethod(authentication.getAuthenticationMethod())).collect(Collectors.toSet())))
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
                .tokenSettings(TokenSettings.builder()
                        .accessTokenTimeToLive(Duration.ofHours(client.getClientTokenSettings().getAccessTokenTimeToLive()))
                        .accessTokenFormat(new OAuth2TokenFormat(client.getClientTokenSettings().getType()))
                        .build())
                .build();
    }


}
