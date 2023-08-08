package com.example.BookAuthor.Service;

import com.example.BookAuthor.Dto.RequestDto.AuthorDto;
import com.example.BookAuthor.Dto.ResponseDto.AuthorReponseDto;
import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.Models.Book;
import com.example.BookAuthor.Repository.AuthorRepository;
import com.example.BookAuthor.Repository.BookRepository;
import com.example.BookAuthor.Transformer.AuthorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String addAuthor(AuthorDto authorDto) {
        Author author = AuthorTransformer.DtoToEntity(authorDto);

        authorRepository.save(author);
        return "Author is added to the database";
    }

    public List<Author> findAuthor() {
        List<Book> bookList = bookRepository.findAll();

        int maxPage = 0;

        for(Book book : bookList){
            if(book.getPages() > maxPage){
                maxPage = book.getPages();
            }
        }

        List<Author> list = new ArrayList<>();

        for(Book book : bookList){
            if(book.getPages()==maxPage){
                list.add(book.getAuthor());
            }
        }

        return list;
    }

    public Integer getNum(Double rating) {

        List<Author> authors = authorRepository.findAll();

        int count = 0;

        for(Author author : authors){
            if(author.getRating() > rating){
                count += author.getBookList().size();
            }
        }
        return count;
    }
}
