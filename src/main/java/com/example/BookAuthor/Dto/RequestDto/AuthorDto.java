package com.example.BookAuthor.Dto.RequestDto;

import com.example.BookAuthor.Enums.Gender;
import lombok.Data;

@Data
public class AuthorDto {

    private String name;

    private Integer age;

    private Gender gender;

    private double rating;
}
