package com.example.AG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AG.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Long> {


}