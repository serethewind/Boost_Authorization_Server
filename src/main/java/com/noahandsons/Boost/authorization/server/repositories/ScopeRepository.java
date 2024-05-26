package com.noahandsons.Boost.authorization.server.repositories;

import com.noahandsons.Boost.authorization.server.entities.Scopes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScopeRepository extends JpaRepository<Scopes, Integer> {
}
