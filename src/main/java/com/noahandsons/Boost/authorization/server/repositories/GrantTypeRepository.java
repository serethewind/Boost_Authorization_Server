package com.noahandsons.Boost.authorization.server.repositories;

import com.noahandsons.Boost.authorization.server.entities.GrantTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrantTypeRepository extends JpaRepository<GrantTypes, Integer> {
}
