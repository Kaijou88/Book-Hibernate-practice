package com.hibernate.book.service.impl;

import com.hibernate.book.dao.AuthorDao;
import com.hibernate.book.lib.Inject;
import com.hibernate.book.lib.Service;
import com.hibernate.book.model.Author;
import com.hibernate.book.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Inject
    private AuthorDao authorDao;

    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }
}
