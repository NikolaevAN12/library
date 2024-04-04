package com.example.AG.auth.repository;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.AG.auth.UserRegistrationDto;
import com.example.AG.auth.model.Account;


public interface UserInterface extends UserDetailsService {

    Account findByEmail(String email);

    Account save(UserRegistrationDto registration);
}
