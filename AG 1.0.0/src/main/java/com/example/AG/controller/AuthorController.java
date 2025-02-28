package com.example.AG.controller;

import com.example.AG.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AG.model.Author;


import java.util.Optional;


@RestController
@RequestMapping("library/v1")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PutMapping("/author")// ссылки
    @Operation(summary = "Добавление записи автора ", description = "Позволяет добавить запись по переданному json ")
    public Author saveAuthor(@RequestBody Author author) {

        return authorService.addAuthor(author);

    }

    @PatchMapping("/author/{id}")
    @Operation(summary = "Обновление записи автора по переданному id", description = "Позволяет обновить запись по полученному из ссылки id ")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {

        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/author/{id}")
    @Operation(summary = "Удаление записи автора по переданному id", description = "Позволяет удалить запись по id")
    public void deleteAuthor(@PathVariable @Parameter(description = "id книги") Long id) {
        authorService.deleteAuthor(id);

    }

    @GetMapping("/author")
    @Operation(summary = "Вывод всех авторов")
    public ResponseEntity getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PostMapping("/author")
    @Operation(summary = "Получение записи автора по id ", description = "Позволяет получить автора по полученному параметру id")
    public Optional<Author> getAuthorsById(@RequestParam @Parameter(description = "id книги") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author/pages")
    public Page<Author> findAllPagesAuthors(@RequestParam("page") @Parameter(description = "Номер страницы") int page,
                                            @RequestParam("size") @Parameter(description = "Размер страницы") int size, @RequestParam("sort") @Parameter(description = "Параметр для сортировки") String sort) {
        return authorService.findAllPagesAuthors(page, size, sort);
    }
}
