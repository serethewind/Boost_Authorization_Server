//package com.noahandsons.Boost.authorization.server.services;
//
//import com.noahandsons.Boost.authorization.server.entities.*;
//import com.noahandsons.Boost.authorization.server.mappers.Mapper;
//import com.noahandsons.Boost.authorization.server.repositories.ClientRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class ClientService implements RegisteredClientRepository {
//
//    private final ClientRepository clientRepository;
//
//    @Override
//    @Transactional
//    public void save(RegisteredClient registeredClient) {
//        Client client = Client.builder()
//                .clientId(registeredClient.getClientId())
//                .secret(registeredClient.getClientSecret())
//                .grantTypes(registeredClient.getAuthorizationGrantTypes().stream().map(Mapper::from).collect(Collectors.toSet()))
//                .redirectUrls(registeredClient.getRedirectUris().stream().map(Mapper::urlFrom).collect(Collectors.toList()))
//                .scopes(registeredClient.getScopes().stream().map(Mapper::scopeFrom).collect(Collectors.toList()))
//                .authenticationMethods(registeredClient.getClientAuthenticationMethods().stream().map(Mapper::from).collect(Collectors.toSet()))
//                .build();
//
//        clientRepository.save(client);
//    }
//
//    @Override
//    public RegisteredClient findById(String id) {
//       var client = clientRepository.findById(Integer.parseInt(id)).orElseThrow(() -> new RuntimeException("Resource not found"));
//       return Mapper.from(client);
//    }
//
//    @Override
//    public RegisteredClient findByClientId(String clientId) {
//        var client = clientRepository.findByClientId(clientId).orElseThrow(() -> new RuntimeException("Resource not found"));
//        return Mapper.from(client);
//    }
//
//}
