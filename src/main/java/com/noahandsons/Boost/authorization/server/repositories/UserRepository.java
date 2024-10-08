package com.noahandsons.Boost.authorization.server.repositories;

import com.noahandsons.Boost.authorization.server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = ?1")
    Optional<User> findByUsername (String username);


}
