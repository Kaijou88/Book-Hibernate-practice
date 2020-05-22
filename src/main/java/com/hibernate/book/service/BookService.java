package com.hibernate.book.service;

import com.hibernate.book.model.Author;
import com.hibernate.book.model.Book;
import com.hibernate.book.model.Gender;
import java.util.List;

public interface BookService {
    Book add(Book book);

    List<Book> getByTitle(String title);

    List<Book> getByAuthor(Author author);

    List<Book> getByGender(Gender gender);
}
