package com.example.BookAuthor.Controllers;

import com.example.BookAuthor.Dto.RequestDto.BookDto;
import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto){
        try{
            String mess = bookService.addBook(bookDto);
            return new ResponseEntity<>(mess, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Books")
    public ResponseEntity<Integer> books(@RequestParam String name, @RequestParam Integer yop){
        Integer num = bookService.getNum(name, yop);

        return new ResponseEntity<>(num, HttpStatus.OK);
    }
}
