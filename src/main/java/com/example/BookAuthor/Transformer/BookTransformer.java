package com.example.BookAuthor.Transformer;

import com.example.BookAuthor.Dto.RequestDto.BookDto;
import com.example.BookAuthor.Models.Book;

public class BookTransformer {

    public static Book DtoToEntity(BookDto bookDto){
        Book book = Book.builder().name(bookDto.getBookName()).pages(bookDto.getPages()).build();

        return book;
    }
}
