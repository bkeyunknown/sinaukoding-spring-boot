package com.mrf.sinaikoding.perpustakaan.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "loan")
@Setter
@Getter
@NoArgsConstructor
public class Loan extends BaseEntity<Loan>{

    private static final long serialVersionUID = 3900723738654601879L;

    public enum StatusLoan {
        BORROWED,
        RETURNED
    }

    @Column(name = "type_identity")
    private String typeIdentity;

    @Column(name = "number_identity")
    private String numberidentity;

    @Column(name = "duration")
    private String duration;

    @Column(name = "loan_date")
    @Temporal(DATE)
    private Date loanDate;

    @Column(name = "return_date")
    @Temporal(DATE)
    private Date returnDate;

    @Column(name = "status")
    @Enumerated(STRING)
    private StatusLoan status;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
