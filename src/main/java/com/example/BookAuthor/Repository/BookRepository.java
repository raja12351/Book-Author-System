package com.example.BookAuthor.Repository;

import com.example.BookAuthor.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
