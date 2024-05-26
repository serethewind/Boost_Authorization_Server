package com.noahandsons.Boost.authorization.server.repositories;

import com.noahandsons.Boost.authorization.server.entities.RedirectUrls;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedirectUrlsRepository extends JpaRepository<RedirectUrls, Integer> {
}
