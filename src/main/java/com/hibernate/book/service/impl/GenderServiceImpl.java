package com.hibernate.book.service.impl;

import com.hibernate.book.dao.GenderDao;
import com.hibernate.book.lib.Inject;
import com.hibernate.book.lib.Service;
import com.hibernate.book.model.Gender;
import com.hibernate.book.service.GenderService;

@Service
public class GenderServiceImpl implements GenderService {
    @Inject
    private GenderDao genderDao;

    @Override
    public Gender add(Gender gender) {
        return genderDao.add(gender);
    }
}
