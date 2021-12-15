package com.mrf.sinaikoding.perpustakaan.dao;

import com.mrf.sinaikoding.perpustakaan.entity.Loan;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Repository
public class LoanDAO extends BaseDAO<Loan>{
    @Override
    public List<Predicate> predicates(Loan param, CriteriaBuilder builder, Root<Loan> root, boolean isCount) {
        List<Predicate> predicates = super.predicates(param, builder, root, isCount);

        return predicates;
    }

    public List<Loan> findByDate(Loan param, Date startDate, Date endDate) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Loan> query = builder.createQuery(Loan.class);

        Root<Loan> root = query.from(Loan.class);

        if (param != null) {
            if (param.getUser() != null) {
                query.where(builder.equal(root.get("user").get("id"), param.getUser().getId()));
            }
        }

        query.where(builder.between(root.get("loanDate"), startDate, endDate));
        query.orderBy(builder.asc(root.get("id")));

        root.fetch("book", JoinType.INNER);
        root.fetch("user", JoinType.LEFT); // Sementara  menggunakan LEFT karena user belum ada

        TypedQuery<Loan> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }

}
