package com.project.accountBook.dto;

import com.project.accountBook.domain.AccountBook;
import com.project.accountBook.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveRequestDto {
    private String email;
    private Long balance;

    @Builder
    public SaveRequestDto(String email, Long balance) {
        this.email = email;
        this.balance = balance;
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .balance(balance)
                .build();
    }
}
