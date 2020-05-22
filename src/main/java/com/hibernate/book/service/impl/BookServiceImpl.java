package com.hibernate.book.service.impl;

import com.hibernate.book.dao.BookDao;
import com.hibernate.book.lib.Inject;
import com.hibernate.book.lib.Service;
import com.hibernate.book.model.Author;
import com.hibernate.book.model.Book;
import com.hibernate.book.model.Gender;
import com.hibernate.book.service.BookService;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Inject
    private BookDao bookDao;

    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public List<Book> getByTitle(String title) {
        return bookDao.getByTitle(title);
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        return bookDao.getByAuthor(author);
    }

    @Override
    public List<Book> getByGender(Gender gender) {
        return bookDao.getByGender(gender);
    }
}
