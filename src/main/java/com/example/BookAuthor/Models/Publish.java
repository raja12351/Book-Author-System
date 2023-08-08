package com.example.BookAuthor.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "publish")
@Data
public class Publish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publishId;

    private Integer YOP;

    @OneToOne
    @JoinColumn
    private Book book;

    @OneToOne
    @JoinColumn
    private Author author;
}
