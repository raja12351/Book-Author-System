package com.example.BookAuthor.Repository;

import com.example.BookAuthor.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    public Author findByName(String authorName);
}
