package com.mrf.sinaikoding.perpustakaan.service;

import com.mrf.sinaikoding.perpustakaan.dao.BaseDAO;
import com.mrf.sinaikoding.perpustakaan.dao.BookDAO;
import com.mrf.sinaikoding.perpustakaan.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<Book>{

    @Autowired
    private BookDAO dao;

    @Override
    protected BaseDAO<Book> getDAO() {
        return dao;
    }

}
