package com.mrf.sinaikoding.perpustakaan.service;

import com.mrf.sinaikoding.perpustakaan.dao.BaseDAO;
import com.mrf.sinaikoding.perpustakaan.dao.UserDAO;
import com.mrf.sinaikoding.perpustakaan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User>{

    @Autowired
    private UserDAO dao;

    @Override
    protected BaseDAO<User> getDAO() {
        return dao;
    }

}
