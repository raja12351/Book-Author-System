package com.example.BookAuthor.Models;

import com.example.BookAuthor.Enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "author")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(scale = 2)
    private Double rating;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> bookList;

    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL)
    private Publish publish;
}
