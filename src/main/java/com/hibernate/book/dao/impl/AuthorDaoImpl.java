package com.hibernate.book.dao.impl;

import com.hibernate.book.dao.AuthorDao;
import com.hibernate.book.exceptions.DataProcessingException;
import com.hibernate.book.lib.Dao;
import com.hibernate.book.model.Author;
import com.hibernate.book.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author add(Author author) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long authorId = (Long) session.save(author);
            transaction.commit();
            author.setId(authorId);
            return author;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Author entity", e);
        }
    }
}
