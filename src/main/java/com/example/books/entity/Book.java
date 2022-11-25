package com.example.books.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String author;
    private int publishYear;

}
