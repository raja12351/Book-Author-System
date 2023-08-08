package com.example.BookAuthor.Service;

import com.example.BookAuthor.Dto.RequestDto.BookDto;
import com.example.BookAuthor.Exceptions.AuthorNotFound;
import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.Models.Book;
import com.example.BookAuthor.Repository.AuthorRepository;
import com.example.BookAuthor.Repository.BookRepository;
import com.example.BookAuthor.Transformer.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    public String addBook(BookDto bookDto) throws AuthorNotFound{

        Author author = authorRepository.findByName(bookDto.getAuthorName());

        if(author== null){
            throw new AuthorNotFound("No Author present");
        }

        Book book = BookTransformer.DtoToEntity(bookDto);

        book.setAuthor(author);
        List<Book> bookList  = author.getBookList();
        bookList.add(book);
        author.setBookList(bookList);

        bookRepository.save(book);
        authorRepository.save(author);

        return "Book is added successfully";
    }

    public Integer getNum(String name, Integer yop) {

        Author author = authorRepository.findByName(name);

        int count = 0;

        List<Book> bookList = author.getBookList();
        for(Book book : bookList){
            if(book.getPublish().getYOP()==yop){
                count++;
            }
        }

        return count;
    }
}
