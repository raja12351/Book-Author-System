package com.example.BookAuthor.Transformer;

import com.example.BookAuthor.Dto.RequestDto.AuthorDto;
import com.example.BookAuthor.Models.Author;

public class AuthorTransformer {

    public static Author DtoToEntity(AuthorDto authorDto){
        Author author = Author.builder().name(authorDto.getName()).age(authorDto.getAge())
                .rating(authorDto.getRating()).gender(authorDto.getGender()).build();

        return author;
    }
}
