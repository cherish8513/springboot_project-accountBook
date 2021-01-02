package com.project.accountBook.dto;

import com.project.accountBook.domain.AccountBook;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AccountBookListResponseDto {
    private String email;
    private String money;
    private Long balance;
    private LocalDateTime createdDate;

    public AccountBookListResponseDto(AccountBook entity) {
        this.email = entity.getEmail();
        this.money = entity.getMoney();
        this.balance = entity.getBalance();
        this.createdDate = entity.getCreatedDate();
    }
}
