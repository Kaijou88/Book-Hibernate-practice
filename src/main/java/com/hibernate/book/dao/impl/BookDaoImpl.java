package com.hibernate.book.dao.impl;

import com.hibernate.book.dao.BookDao;
import com.hibernate.book.exceptions.DataProcessingException;
import com.hibernate.book.lib.Dao;
import com.hibernate.book.model.Author;
import com.hibernate.book.model.Book;
import com.hibernate.book.model.Gender;
import com.hibernate.book.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class BookDaoImpl implements BookDao {
    @Override
    public Book add(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long bookId = (Long) session.save(book);
            transaction.commit();
            book.setId(bookId);
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Book entity", e);
        }
    }

    @Override
    public List<Book> getByTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
            Root<Book> root = query.from(Book.class);
            CriteriaQuery<Book> criteriaQuery =
                    query.where(criteriaBuilder.equal(root.get("title"), title));
            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
            Root<Book> root = query.from(Book.class);
            CriteriaQuery<Book> criteriaQuery =
                    query.select(root).where(criteriaBuilder.equal(root.get("authors"), author));
            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    @Override
    public List<Book> getByGender(Gender gender) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
            Root<Book> root = query.from(Book.class);
            CriteriaQuery<Book> criteriaQuery =
                    query.where(criteriaBuilder.equal(root.get("gender"), gender));
            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
