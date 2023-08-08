package com.example.BookAuthor.Controllers;

import com.example.BookAuthor.Dto.RequestDto.AuthorDto;
import com.example.BookAuthor.Dto.ResponseDto.AuthorReponseDto;
import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDto authorDto){
        String mess = authorService.addAuthor(authorDto);
        return new ResponseEntity<>(mess, HttpStatus.ACCEPTED);
    }

    @GetMapping("/author-list")
    public ResponseEntity<List<Author>> findAuthor(){
        List<Author> list = authorService.findAuthor();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/noOfAuthor")
    public ResponseEntity<Integer> findNumber(@RequestParam Double rating){
        Integer num = authorService.getNum(rating);
        return new ResponseEntity<>(num, HttpStatus.ACCEPTED);
    }
}
