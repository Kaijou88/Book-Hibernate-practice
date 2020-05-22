package com.hibernate.book.dao;

import com.hibernate.book.model.Author;
import com.hibernate.book.model.Book;
import com.hibernate.book.model.Gender;
import java.util.List;

public interface BookDao {
    Book add(Book book);

    List<Book> getByTitle(String title);

    List<Book> getByAuthor(Author author);

    List<Book> getByGender(Gender gender);
}
