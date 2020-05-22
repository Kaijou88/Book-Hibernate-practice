package com.hibernate.book.dao.impl;

import com.hibernate.book.dao.GenderDao;
import com.hibernate.book.exceptions.DataProcessingException;
import com.hibernate.book.lib.Dao;
import com.hibernate.book.model.Gender;
import com.hibernate.book.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class GenderDaoImpl implements GenderDao {
    @Override
    public Gender add(Gender gender) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long genderId = (Long) session.save(gender);
            transaction.commit();
            gender.setId(genderId);
            return gender;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Gender entity", e);
        }
    }
}
