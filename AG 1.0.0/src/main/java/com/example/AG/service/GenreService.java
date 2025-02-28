package com.example.AG.service;

import com.example.AG.model.Genre;
import com.example.AG.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service

public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();

    }

    public Optional<Genre> findGenreById(Long id) {

        return genreRepository.findById(id);

    }

    public Genre addGenre(Genre genre) {
        if (genreRepository.findById(genre.getId_genre()).isPresent()) {
            Random r = new Random();
            genre.setId_genre(r.nextLong());
        }
        return genreRepository.save(genre);
    }
}
