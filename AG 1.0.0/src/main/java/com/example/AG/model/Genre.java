package com.example.AG.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Data
@Table(name = "genre")
public class Genre {
    @Id
    private Long id_genre;
    @Column(nullable = false)
    private String genreName;


}