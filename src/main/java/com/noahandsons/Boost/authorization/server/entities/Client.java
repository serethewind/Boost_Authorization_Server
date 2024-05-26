package com.noahandsons.Boost.authorization.server.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "client_id")
    private String clientId;

    private String secret;

    @OneToMany(cascade = CascadeType.PERSIST ,mappedBy = "client", fetch = FetchType.EAGER)
    private Set<GrantTypes> grantTypes;

    @OneToMany(cascade =CascadeType.PERSIST, mappedBy = "client", fetch = FetchType.EAGER)
    private List<RedirectUrls> redirectUrls;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client", fetch = FetchType.EAGER)
    private List<Scopes> scopes;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client", fetch = FetchType.EAGER)
    private Set<AuthenticationMethods> authenticationMethods;

    @OneToOne(mappedBy = "client")
    private ClientTokenSettings clientTokenSettings;
}
