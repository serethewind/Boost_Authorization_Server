package com.noahandsons.Boost.authorization.server.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "token_settings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientTokenSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "access_token_ttl")
    private int accessTokenTimeToLive;

    private String type;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
