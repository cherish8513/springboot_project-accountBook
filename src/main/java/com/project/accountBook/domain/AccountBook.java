package com.project.accountBook.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class AccountBook extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String email;

    @Column(nullable = false, updatable = false)
    private String money;

    @Column(nullable = false, updatable = false)
    private Long balance;

    @Builder
    public AccountBook(String email, String money, Long balance) {
        this.email = email;
        this.money = money;
        this.balance = balance;
    }

}
