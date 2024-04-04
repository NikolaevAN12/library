package com.example.AG.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.AG.auth.model.Account;

@Repository
public interface UserRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String email);
}
