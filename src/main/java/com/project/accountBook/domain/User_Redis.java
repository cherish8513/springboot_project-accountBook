package com.project.accountBook.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@RedisHash
public class User_Redis {

    @Id
    private Long id;
    private String email;
    private Long balance;
    private String name;
    private String picture;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Builder
    public User_Redis(String email, Long balance, String name, String picture, Role role ) {
        this.email = email;
        this.balance = balance;
        this.name = name;
        this.picture = picture;
        this.role = role;
    }

    @Builder
    public User_Redis(String email, Long balance) {
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

    public User_Redis update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}
