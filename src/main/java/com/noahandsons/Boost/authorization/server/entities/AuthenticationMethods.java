package com.noahandsons.Boost.authorization.server.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authentication_methods")
public class AuthenticationMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "authentication_method")
    private String authenticationMethod;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
