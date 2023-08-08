package com.example.BookAuthor.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String name;

    private Integer pages;

    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToOne(mappedBy = "books", cascade = CascadeType.ALL)
    private Publish publish;
}
