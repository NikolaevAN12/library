package com.example.AG.service;

import com.example.AG.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.AG.model.Author;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public List<Author> getAllAuthors() {
        return authorRepository.findAll();

    }

    public Optional<Author> getAuthorById(Long id) {

        return authorRepository.findById(id);

    }

    public Page<Author> findAllPagesAuthors(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return authorRepository.findAll(pageable);
    }

    public Author addAuthor(Author author) {

        if (authorRepository.findById(author.getId()).isPresent()) {
            Random r = new Random();
            author.setId(r.nextLong());
        }

        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author) {
        author.setId(id);
        return authorRepository.save(author);

    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
