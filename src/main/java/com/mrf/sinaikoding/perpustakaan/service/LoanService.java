package com.mrf.sinaikoding.perpustakaan.service;

import com.mrf.sinaikoding.perpustakaan.dao.BaseDAO;
import com.mrf.sinaikoding.perpustakaan.dao.LoanDAO;
import com.mrf.sinaikoding.perpustakaan.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService extends BaseService<Loan>{

    @Autowired
    private LoanDAO dao;

    @Override
    protected BaseDAO<Loan> getDAO() {
        return dao;
    }

}
