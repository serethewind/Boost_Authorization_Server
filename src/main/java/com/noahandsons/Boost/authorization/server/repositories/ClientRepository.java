package com.noahandsons.Boost.authorization.server.repositories;

import com.noahandsons.Boost.authorization.server.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("Select c from Client c where c.clientId = ?1")
    Optional<Client> findByClientId(String clientId);
}
