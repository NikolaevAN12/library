package com.example.AG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AG.model.Book;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthor_SurnameAndGenre_GenreName(String author_surname, String genre_genreName);

}
