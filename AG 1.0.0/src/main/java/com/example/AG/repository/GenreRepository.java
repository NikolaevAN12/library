package com.example.AG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AG.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
