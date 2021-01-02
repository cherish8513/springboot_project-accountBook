package com.project.accountBook.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email", nullable = false, updatable = false)
    private String email;

    @Column
    private Long balance;

    @Column()
    private String name;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;


    @Builder
    public User(String email, Long balance, String name, String picture, Role role ) {
        this.email = email;
        this.balance = balance;
        this.name = name;
        this.picture = picture;
        this.role = role;
    }

    @Builder
    public User(String email, Long balance) {
        this.email = email;
        this.balance = balance;
    }

    public Long withdraw(Long money){
        this.balance = this.balance - money;
        return balance;
    }

    public Long deposit(Long money){
        this.balance = this.balance + money;
        return balance;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}
