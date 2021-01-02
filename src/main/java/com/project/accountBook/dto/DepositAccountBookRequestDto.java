package com.project.accountBook.dto;

import com.project.accountBook.domain.AccountBook;
import com.project.accountBook.domain.User;
import lombok.Builder;

public class DepositAccountBookRequestDto {
    private String email;
    private String money;
    private Long balance;

    @Builder
    public DepositAccountBookRequestDto(String email, Long money, Long balance) {
        this.email = email;
        this.money = "+" + money;
        this.balance = balance;
    }

    public AccountBook toEntity(){
        return AccountBook.builder()
                .email(email)
                .money(money)
                .balance(balance)
                .build();
    }
}
